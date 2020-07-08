package com.cdk.challenge.service;

import com.cdk.challenge.model.Customer;
import com.cdk.challenge.model.Bill;
import com.cdk.challenge.service.impl.DiscountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BillServiceTest {

    private DiscountService discountService;

    @Before
    public void setUp() throws Exception {
        discountService = new DiscountServiceImpl();
    }

    @Test
    public void test1() {
        Bill bill = discountService.calculateDiscount(5000, Customer.Type.REGULAR);
        Assert.assertEquals(5000, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test2() {
        Bill bill = discountService.calculateDiscount(10000, Customer.Type.REGULAR);
        Assert.assertEquals(9500, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test3() {
        Bill bill = discountService.calculateDiscount(15000, Customer.Type.REGULAR);
        Assert.assertEquals(13500, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test4() {
        Bill bill = discountService.calculateDiscount(4000, Customer.Type.PREMIUM);
        Assert.assertEquals(3600, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test5() {
        Bill bill = discountService.calculateDiscount(8000, Customer.Type.PREMIUM);
        Assert.assertEquals(7000, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test6() {
        Bill bill = discountService.calculateDiscount(12000, Customer.Type.PREMIUM);
        Assert.assertEquals(10200, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test7() {
        Bill bill = discountService.calculateDiscount(20000, Customer.Type.PREMIUM);
        Assert.assertEquals(15800, bill.getFinalAmount(), 0.0f);
    }

    @Test
    public void test8() {
        Bill bill = discountService.calculateDiscount(20000, Customer.Type.NEW);
        Assert.assertEquals(15800, bill.getFinalAmount(), 0.0f);
    }
}