package com.cdk.challenge.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Customer {
    public enum Type {
        REGULAR, PREMIUM
    }

    private Type customerType;
    private List<PurchaseSlab> purchaseSlabs;
}
