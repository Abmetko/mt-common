package core.mt;

import java.util.Arrays;
import java.util.List;


public enum ProjectPackages {

    GLOBAL_TRADE_ATF(new String[]{"com.mobiletrade.fms.globaltradeatf","com.tradeatf.global"}),
    INVESTING_101(new String[]{"com.brand101investing","com.101investing"}),
    RO_INVESTING(new String[]{"com.roinvesting"}),
    ET_FINANCE(new String[]{"com.etfinance"}),
    T1(new String[]{"com.tmarkets","com.gcb.T1"}),
    TRADED_WELL(new String[]{"com.tradedwell"}),
    HFT_TRADING_AU(new String[]{"au.com.hftrading"}),
    HFT_TRADING(new String[]{"com.hftrading"}),
    PRIME_FIN(new String[]{"com.primefine"}),
    INVEST_LITE(new String[]{"com.investlite","com.bayline.InvestLite"}),
    CAPIXAL(new String[]{"com.capixal"}),
    IGMFX(new String[]{"com.igmfx"}),
    INCEPTIAL(new String[]{"com.inceptial","com.inceptial.app"});

    private final String[] PROJECT_NAME;

    ProjectPackages(String[] projectName) {
        this.PROJECT_NAME = projectName;
    }

    public String[] getValue() {
        return PROJECT_NAME;
    }

    public List<String> getValueAsList() {
        return Arrays.asList(PROJECT_NAME);
    }
}