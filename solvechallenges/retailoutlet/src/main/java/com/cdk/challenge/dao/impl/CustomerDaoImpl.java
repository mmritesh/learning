package com.cdk.challenge.dao.impl;

import com.cdk.challenge.dao.CustomerDao;
import com.cdk.challenge.db.DbData;
import com.cdk.challenge.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer findByType(Customer.Type type) {
        return DbData.CUSTOMER_MAP.get(type);
    }
}
