package com.techv.d2h.dao.impl;

import com.techv.d2h.dao.FeatureDao;
import com.techv.d2h.db.InMemoryDb;
import com.techv.d2h.model.Feature;
import com.techv.d2h.service.Logger;
import com.techv.d2h.service.impl.LoggerImpl;

import java.util.Arrays;
import java.util.List;

public class FeatureDaoImpl implements FeatureDao {
    private static final Logger LOGGER = new LoggerImpl();

    /**
     * For now the values are hardcoded. We can replace this with either jdbc template or JPA.
     * This can be cached in order to not call database repeatedly.
     * @return
     */
    public List<Feature> findAll() {
        return InMemoryDb.FEATURES;
    }
}
