package com.cdk.challenge.service.impl;

import com.cdk.challenge.dao.CustomerDao;
import com.cdk.challenge.dao.impl.CustomerDaoImpl;
import com.cdk.challenge.model.Customer;
import com.cdk.challenge.model.Bill;
import com.cdk.challenge.model.PurchaseSlab;
import com.cdk.challenge.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {
    private CustomerDao customerDao;

    public DiscountServiceImpl() {
        this.customerDao = new CustomerDaoImpl();
    }

    @Override
    public Bill calculateDiscount(float purchaseAmount, Customer.Type customerType) {
        Customer customer = customerDao.findByType(customerType);
        Bill bill = new Bill(purchaseAmount);

        for (PurchaseSlab purchaseSlab : customer.getPurchaseSlabs()) {
            if (purchaseAmount > purchaseSlab.getMax() && purchaseSlab.getMax() != -1) {
                bill.addDiscount(purchaseSlab.getMaxDiscount());
                continue;
            }
            bill.addDiscount(calculateDiscount(purchaseAmount, purchaseSlab));
            break;
        }
        return bill;
    }

    private float calculateDiscount(float purchaseAmount, PurchaseSlab purchaseSlab) {
        return (purchaseAmount - purchaseSlab.getMin()) * purchaseSlab.getPercentDiscount() / 100;
    }
}
