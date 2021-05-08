package core.mt.android;

public enum ProjectPackages {

    GLOBAL_TRADE_ATF("com.mobiletrade.fms.globaltradeatf"),
    INVESTING_101("com.brand101investing"),
    RO_INVESTING("com.roinvesting"),
    ET_FINANCE("com.etfinance"),
    T1("com.tmarkets"),
    TRADED_WELL("com.tradedwell"),
    HFT_TRADING_AU("au.com.hftrading"),
    HFT_TRADING("com.hftrading"),
    PRIME_FIN("com.primefine"),
    INVEST_LITE("com.investlite");

    private final String PROJECT_NAME;

    ProjectPackages(String projectName) {
        this.PROJECT_NAME = projectName;
    }

    public String getValue() {
        return PROJECT_NAME;
    }
}