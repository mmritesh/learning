package com.techv.d2h.dao.impl;

import com.techv.d2h.dao.SubscriptionPackDao;
import com.techv.d2h.db.InMemoryDb;
import com.techv.d2h.model.SubscriptionPack;

import java.util.List;

public class SubscriptionPackDaoImpl implements SubscriptionPackDao {
    @Override
    public List<SubscriptionPack> findAll() {
        return InMemoryDb.SUBSCRIPTION_PACKS;
    }

    @Override
    public SubscriptionPack findById(int id) {
        return InMemoryDb.SUBSCRIPTION_PACKS.stream()
                .filter(subscriptionPack -> subscriptionPack.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
