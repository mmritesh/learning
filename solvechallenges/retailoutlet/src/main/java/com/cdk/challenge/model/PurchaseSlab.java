package com.cdk.challenge.model;

import lombok.Getter;

@Getter
public class PurchaseSlab {

    public enum Currency {
        DOLLAR;
    }

    private float min;
    private float max;
    private float percentDiscount;
    private final float maxDiscount;
    private final static Currency currency = Currency.DOLLAR;

    public PurchaseSlab(float min, float max, float percentDiscount) {
        this.min = min;
        this.max = max;
        this.percentDiscount = percentDiscount;
        this.maxDiscount = max != -1 ? (max - min) * percentDiscount/100 : 0;
    }
}
