package core.mt.utils;

public class ValuesUtils {

    public static String getOnlyDigitsFromValue(String text){
        return text.replaceAll("[^\\d.]","");
    }

    public static String removeDigitsFromValue(String text){
        return text.replaceAll("\\d.","");
    }

    public static String replaceCommaToDot(String text) {
        return text.replace(",", ".");
    }

    public static String replaceDotToComma(String text) {
        return text.replace(",", ".");
    }

    public static double getDoubleValue(String text) {
        return Double.parseDouble(replaceCommaToDot(text));
    }

    public static String assignStringValue(String value, String assign) {
        return String.format(assign, value);
    }
}