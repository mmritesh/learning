package com.cdk.challenge.service;

import com.cdk.challenge.model.Customer;
import com.cdk.challenge.model.Bill;

public interface DiscountService {
    Bill calculateDiscount(float purchaseAmount, Customer.Type customerType);
}
