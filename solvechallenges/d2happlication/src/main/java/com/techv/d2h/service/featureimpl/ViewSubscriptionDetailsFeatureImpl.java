package com.techv.d2h.service.featureimpl;

import com.techv.d2h.model.Channel;
import com.techv.d2h.model.ServicePack;
import com.techv.d2h.model.SubscriptionPack;
import com.techv.d2h.model.User;
import com.techv.d2h.util.Constants;

public class ViewSubscriptionDetailsFeatureImpl extends AbstractFeatureImpl {
    @Override
    public void process() {
        User user = userDao.findById(Constants.LOGGED_IN_USER_ID);

        LOGGER.info(String.format("Currently subscribed packs and channels: "));

        if (user.getSubscriptionPacks() != null)  {
            LOGGER.info(user.getSubscriptionPacks().stream().map(SubscriptionPack::getDescription).reduce((s, s2) -> s + " + " + s2).get());
        } else {
            LOGGER.info("No Subscription Packs");
        }
        if (user.getChannels() != null) {
            LOGGER.info(user.getChannels().stream().map(Channel::getName).reduce((s, s2) -> s + " + " + s2 ).get());
        } else {
            LOGGER.info("No Channels Subscribed.");
        }
        LOGGER.info("Currently subscribed services: ");
        if (user.getServicePacks() != null) {
            LOGGER.info(user.getServicePacks().stream().map(ServicePack::getDescription).reduce((s, s2) -> s + " + " + s2).get());
        } else {
            LOGGER.info("No Service Packs Subscribed.");
        }

    }
}
