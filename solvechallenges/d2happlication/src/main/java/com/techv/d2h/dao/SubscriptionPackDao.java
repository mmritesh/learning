package com.techv.d2h.dao;

import com.techv.d2h.model.SubscriptionPack;

import java.util.List;

public interface SubscriptionPackDao {
    List<SubscriptionPack> findAll();
    SubscriptionPack findById(int id);
}
