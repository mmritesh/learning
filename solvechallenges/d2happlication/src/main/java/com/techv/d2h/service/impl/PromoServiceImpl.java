package com.techv.d2h.service.impl;

import com.techv.d2h.service.PromoService;

public class PromoServiceImpl implements PromoService {
    //ToDO: for now returing hardcoded value
    @Override
    public int getDiscount(int userId) {
        return 30;
    }
}
