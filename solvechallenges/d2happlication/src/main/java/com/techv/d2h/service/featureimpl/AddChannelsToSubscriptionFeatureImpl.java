package com.techv.d2h.service.featureimpl;

import com.techv.d2h.model.Channel;
import com.techv.d2h.model.User;
import com.techv.d2h.util.Constants;

import java.util.ArrayList;

public class AddChannelsToSubscriptionFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        int totalPrice = 0;
        channelDao.findAll().forEach(channel -> LOGGER.info(channel.getId() + ". " + channel.getName() + ": " + channel.getPrice()  + " Rs."));
        LOGGER.info("Choose your channel to add (Separated by comma): ");
        String[] input = this.scanner.next().split(",");
        User user = userDao.findById(Constants.LOGGED_IN_USER_ID);

        if (user.getChannels() == null) {
            user.setChannels(new ArrayList<>());
        }

        for (String ch : input) {
            Channel channel = channelDao.findById(Integer.valueOf(ch));
            if(channel != null) {
                user.getChannels().add(channel);
                totalPrice += channel.getPrice();
            }
        }

        if(totalPrice > user.getAccountBalance()) {
            LOGGER.error("You don't have sufficient balance.");
            return;
        }

        user.setAccountBalance(user.getAccountBalance() - totalPrice);
        user = userDao.save(user);
        LOGGER.info("Channels added successfully.");
        LOGGER.info(String.format("Account balance: %s Rs", user.getAccountBalance()));
    }
}
