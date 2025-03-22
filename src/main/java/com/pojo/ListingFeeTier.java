package com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListingFeeTier {


    @JsonProperty("MinimumTierPrice")
    public int minimumTierPrice;
    @JsonProperty("FixedFee")
    public int fixedFee;

    public int getMinimumTierPrice() {
        return minimumTierPrice;
    }

    public void setMinimumTierPrice(int minimumTierPrice) {
        this.minimumTierPrice = minimumTierPrice;
    }

    public int getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(int fixedFee) {
        this.fixedFee = fixedFee;
    }
}
