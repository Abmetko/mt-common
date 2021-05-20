package core.mt.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AssetLeverage {

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "leverage")
    private Double leverage;

    @JsonProperty(value = "margin")
    private Double margin;

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

    public Double getMargin() {
        return margin;
    }

    public void setMargin(Double margin) {
        this.margin = margin;
    }
}

/*
{
    "symbol": "ADAUSD",
    "leverage": 2.0,
    "margin": 89.0
}
*/