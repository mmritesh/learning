package com.cdk.challenge.dao;

import com.cdk.challenge.model.Customer;

public interface CustomerDao {
    Customer findByType(Customer.Type type);
}
