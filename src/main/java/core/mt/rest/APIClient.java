package core.mt.rest;

import core.mt.AssetLeverageOptions;
import core.mt.rest.dto.AssetLeverage;
import static core.mt.utils.PropertyLoader.getProperty;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static core.mt.ProjectPackages.*;
import static io.restassured.RestAssured.given;

public class APIClient {

    private static final Logger LOGGER = LogManager.getLogger(APIClient.class);

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    /**
     * browserstack API
     **/
    public static void passTestStatus(String sessionId, String status, String reason) {
        Response response = given().auth()
                .basic(getProperty("browserstack.login"), getProperty("browserstack.password"))
                .header("Content-Type", "application/json")
                .body("{\"status\":\"" + status + "\", \"reason\":\"" + reason + "\"}")
                .when()
                .put("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json");
        response.then()
                .statusCode(200);
    }

    public static String getApplicationData(String app_url) {
        Response response = given().auth()
                .basic(getProperty("browserstack.login"), getProperty("browserstack.password"))
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/recent_apps");
        response.then().extract().response();
        JsonPath path = response.jsonPath();
        List<HashMap<String, Object>> data = path.getList("");
        for (HashMap<String, Object> singleObject : data) {
            if (singleObject.get("app_url").equals(app_url)) {
                return (String) singleObject.get("app_version");
            }
        }
        return null;
    }

    /** brands API **/
    private static String ASSET_LEVERAGE_URL;

    public static String getUserAccessToken(String package_name){
        AssetLeverageOptions assetLeverageOptions = new AssetLeverageOptions(package_name);
        String userId = assetLeverageOptions.getData()[1];
        ASSET_LEVERAGE_URL = assetLeverageOptions.getData()[0];

        String userPassword = getProperty("user.password");
        if(Arrays.asList(HFT_TRADING_AU.getValue()).contains(package_name)){
            userPassword = getProperty("user.password.hft");
        }
        else if(Arrays.asList(HFT_TRADING.getValue()).contains(package_name)){
            userPassword = getProperty("user.password.hft");
        }
        String body = String.format("grant_type=%s&username=%s&password=%s", "password", userId, userPassword);
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("authorization",getProperty("auth.basic"))
                .header("grant_type","password")
                .body(body)
                .when()
                .post(ASSET_LEVERAGE_URL + "/fms/auth/oauth/token");
        response.then().assertThat().statusCode(200);
        String access_token = response.jsonPath().get("access_token");
        LOGGER.debug("User access_token: " + access_token);
        return access_token;
    }

    public static int getAssetLeverage(String package_name){
        String symbol = getProperty("instrument.set");
        if(INCEPTIAL.getValueAsList().contains(package_name)){
            symbol = getProperty("instrument.set.inceptial");
        }
        Response response = given().auth().oauth2(getUserAccessToken(package_name))
                .header("Content-Type", "application/json")
                .body("{\"symbol\":\"" + symbol + "\"}")
                .when()
                .post(ASSET_LEVERAGE_URL + "/fms/leverage");
        Double assetLeverage = response.then().statusCode(200).extract().as(AssetLeverage.class).getLeverage();
        System.out.println(response);
        int asset_leverage = (int) Math.round(assetLeverage);
        LOGGER.debug("Asset leverage(" + ASSET_LEVERAGE_URL + "/fms/leverage" + "): " + asset_leverage);
        return asset_leverage;
    }
}