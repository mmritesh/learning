package com.techv.d2h.patterns.factory;

import com.techv.d2h.dao.FeatureDao;
import com.techv.d2h.dao.impl.FeatureDaoImpl;
import com.techv.d2h.model.Feature;
import com.techv.d2h.service.FeatureService;
import com.techv.d2h.service.Logger;
import com.techv.d2h.service.featureimpl.ExitFeatureImpl;
import com.techv.d2h.service.impl.LoggerImpl;

import java.util.Map;
import java.util.stream.Collectors;

public class FeatureFactory {

    private static final Logger LOGGER = new LoggerImpl();
    private static final String CLASS_PACKAGE_PREFIX = "com.techv.d2h.service.featureimpl.";
    private static final String CLASS_NAME_SUFFIX = "FeatureImpl";
    private Map<Integer, FeatureService> featureServiceMap;

    private FeatureDao featureDao;

    public FeatureFactory() {
        this.featureDao = new FeatureDaoImpl();
        this.featureServiceMap = getFeatureMap();
    }

    public Map<Integer, FeatureService> getFeatureMap() {
        return featureDao.findAll().stream().collect(Collectors.toMap(Feature::getId, feature -> {
            try {
                return (FeatureService) Class.forName(CLASS_PACKAGE_PREFIX + feature.getName() + CLASS_NAME_SUFFIX).newInstance();
            } catch (ClassNotFoundException e) {
                return new ExitFeatureImpl("\"" + feature.getDescription() + "\"" + " feature is not yet supported. Exiting...");
            } catch (IllegalAccessException | InstantiationException e) {
                LOGGER.error("Couldn't instantiate class.", e);
                return new ExitFeatureImpl(feature.getDescription() + " feature is not yet supported. Exiting...");
            }
        }));
    }
    public FeatureService getFeature(int id) {
        return this.featureServiceMap.get(id);
    }
}
