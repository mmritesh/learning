package com.techv.d2h.dao;

import com.techv.d2h.model.Feature;

import java.util.List;

public interface FeatureDao {
    List<Feature> findAll();
}
