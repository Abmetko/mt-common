package core.mt.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AssetLeverage {

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "leverage")
    private Double leverage;

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public void setLeverage(Double leverage){
        this.leverage = leverage;
    }

    public String getSymbol(){
        return symbol;
    }

    public Double getLeverage(){
        return leverage;
    }
}