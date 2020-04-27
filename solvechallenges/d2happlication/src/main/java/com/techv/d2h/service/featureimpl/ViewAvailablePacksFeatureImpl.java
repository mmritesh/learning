package com.techv.d2h.service.featureimpl;

public class ViewAvailablePacksFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        LOGGER.info("Available packs for subscription");
        subscriptionPackDao.findAll().forEach(System.out::println);
        LOGGER.info("Available channels for subscription");
        channelDao.findAll().forEach(System.out::println);
        LOGGER.info("Available services for subscription");
        servicePackDao.findAll().forEach(System.out::println);

    }
}
