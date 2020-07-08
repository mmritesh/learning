package com.cdk.challenge.db;

import com.cdk.challenge.model.Customer;
import com.cdk.challenge.model.PurchaseSlab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DbData {

    private static Customer REGULAR_CUSTOMER = Customer.builder()
            .customerType(Customer.Type.REGULAR)
            .purchaseSlabs(Arrays.asList(
                    new PurchaseSlab(0, 5000, 0),
                    new PurchaseSlab(5000, 10000, Math.random() % 2 == 0 ? 10 : 15),
                    new PurchaseSlab(10000, -1, 20)
            ))
            .build();

    private static Customer PREMIUM_CUSTOMER = Customer.builder()
            .customerType(Customer.Type.PREMIUM)
            .purchaseSlabs(Arrays.asList(
                    new PurchaseSlab(0, 4000, 10),
                    new PurchaseSlab(4000, 8000, 15),
                    new PurchaseSlab(8000, 12000, 20),
                    new PurchaseSlab(12000, -1, 30)
            ))
            .build();

    private static Customer NEW_CUSTOMER = Customer.builder()
            .customerType(Customer.Type.PREMIUM)
            .purchaseSlabs(Arrays.asList(
                    new PurchaseSlab(0, 4000, 10),
                    new PurchaseSlab(4000, 8000, 15),
                    new PurchaseSlab(8000, 12000, 20),
                    new PurchaseSlab(12000, -1, 30)
            ))
            .build();

    public static Map<Customer.Type, Customer> CUSTOMER_MAP = new HashMap<Customer.Type, Customer>() {{
        put(Customer.Type.REGULAR, REGULAR_CUSTOMER);
        put(Customer.Type.PREMIUM, PREMIUM_CUSTOMER);
        put(Customer.Type.NEW, NEW_CUSTOMER);
    }};
}
