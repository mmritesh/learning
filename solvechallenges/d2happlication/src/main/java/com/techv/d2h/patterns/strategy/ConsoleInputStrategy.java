package com.techv.d2h.patterns.strategy;

import com.techv.d2h.dao.FeatureDao;
import com.techv.d2h.dao.impl.FeatureDaoImpl;
import com.techv.d2h.patterns.factory.FeatureFactory;
import com.techv.d2h.service.Logger;
import com.techv.d2h.service.impl.LoggerImpl;

import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

public class ConsoleInputStrategy implements InputStrategy<String> {

    private static final Logger LOGGER = new LoggerImpl();

    private FeatureDao featureDao;
    private Scanner scanner;
    private FeatureFactory featureFactory;

    public ConsoleInputStrategy() {
        this.featureDao = new FeatureDaoImpl();
        this.scanner = new Scanner(new InputStreamReader(in));
        this.featureFactory = new FeatureFactory();
    }


    public void apply(String input) {
        LOGGER.info("Welcome to SatTV");
        while (true) {
            featureDao.findAll().forEach(feature -> {
                LOGGER.info(feature.getId() + " " + feature.getDescription());
            });
            LOGGER.info("Enter the option: ");
            int choice = scanner.nextInt();
            featureFactory.getFeature(choice).process();
            LOGGER.info("===================================================");
        }
    }
}
