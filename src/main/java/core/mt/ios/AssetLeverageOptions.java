package core.mt.ios;

import java.util.HashMap;
import java.util.Map;
import static core.mt.ios.ProjectPackages.*;


public class AssetLeverageOptions {

    private final HashMap<String,String[]> data;
    private final String brandName;

    public AssetLeverageOptions(String brandName){
        this.brandName = brandName;
        data = new HashMap<>();
        data.put(GLOBAL_TRADE_ATF.getValue(), new String[]{"https://api-mobile-live-global.tradeatf.com", "562065"});
        data.put(INVESTING_101.getValue(), new String[]{"https://api-mobile-live.101investing.com", "566656"});
        data.put(RO_INVESTING.getValue(), new String[]{"https://api-mobile-live.roinvesting.com", "566654"});
        data.put(ET_FINANCE.getValue(), new String[]{"https://api-mobile-live.etfinance.com", "570886"});
        data.put(T1.getValue(), new String[]{"https://api-mobile-live.t1markets.com", "572765"});
        data.put(TRADED_WELL.getValue(), new String[]{"https://api-mobile-live.tradedwell.com", "572254"});
        data.put(HFT_TRADING_AU.getValue(), new String[]{"https://api-mobile-live.hftrading.com.au", "571854"});
        data.put(HFT_TRADING.getValue(), new String[]{"https://api-mobile-live.hftrading.com", "571855"});
        data.put(PRIME_FIN.getValue(), new String[]{"https://api-mobile-live.primefine.com", "572783"});
        data.put(INVEST_LITE.getValue(), new String[]{"https://api-mobile-live.investlite.com", "572782"});
        data.put(CAPIXAL.getValue(), new String[]{"https://api-mobile-live.capixal.com", "576103"});
        data.put(IGMFX.getValue(), new String[]{"https://api-mobile-live.igmfx.com", "572785"});
        data.put(INCEPTIAL.getValue(), new String[]{"https://api-mobile-live.inceptial.com", ""});
    }

    public String[] getData(){
        return data.entrySet().stream()
                .filter(e -> e.getKey().equals(brandName))
                .map(Map.Entry::getValue).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such package present"));
    }
}