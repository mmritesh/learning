package com.cdk.challenge.model;

import lombok.Getter;

@Getter
public class Bill {
    private float discount = 0;
    private float finalAmount;
    private float originalAmount;

    public Bill(float originalAmount) {
        this.originalAmount = originalAmount;
    }

    public void addDiscount(float discount) {
        this.discount = this.discount + discount;
        this.finalAmount = this.originalAmount - this.discount;
    }

    private void setDiscount(float discount) {
        this.discount = discount;
    }

    private void setFinalAmount(float finalAmount) {
        this.finalAmount = finalAmount;
    }

    private void setOriginalAmount(float originalAmount) {
        this.originalAmount = originalAmount;
    }
}
