package com.techv.d2h.service;

public interface PromoService {
    /**
     * This is a user promotional campaign service, will calculate the discount given to the user for particular pack
     * based on some logic.
     * @param userId
     * @return
     */
    int getDiscount(int userId);
}
