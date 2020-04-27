package com.techv.d2h.dao.impl;

import com.techv.d2h.dao.ServicePackDao;
import com.techv.d2h.db.InMemoryDb;
import com.techv.d2h.model.ServicePack;

import java.util.List;

public class ServicePackDaoImpl implements ServicePackDao {
    @Override
    public List<ServicePack> findAll() {
        return InMemoryDb.SERVICE_PACKS;
    }

    @Override
    public ServicePack findById(int id) {
        return InMemoryDb.SERVICE_PACKS.get(id);
    }
}
