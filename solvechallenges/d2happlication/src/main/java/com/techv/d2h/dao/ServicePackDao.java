package com.techv.d2h.dao;

import com.techv.d2h.model.ServicePack;

import java.util.List;

public interface ServicePackDao {
    List<ServicePack> findAll();
    ServicePack findById(int id);
}
