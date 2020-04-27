package com.techv.d2h.service.featureimpl;

import com.techv.d2h.dao.SubscriptionPackDao;
import com.techv.d2h.dao.UserDao;
import com.techv.d2h.dao.impl.SubscriptionPackDaoImpl;
import com.techv.d2h.dao.impl.UserDaoImpl;
import com.techv.d2h.model.SubscriptionPack;
import com.techv.d2h.model.User;
import com.techv.d2h.service.FeatureService;
import com.techv.d2h.service.Logger;
import com.techv.d2h.service.NotificationService;
import com.techv.d2h.service.PromoService;
import com.techv.d2h.service.impl.LoggerImpl;
import com.techv.d2h.service.impl.NotificationServiceImpl;
import com.techv.d2h.service.impl.PromoServiceImpl;
import com.techv.d2h.util.Constants;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SubscribeToBasePackFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        LOGGER.info(String.format("Enter the Pack you wish to subscribe: { %s }: ",
                subscriptionPackDao.findAll().stream()
                        .map(subscriptionPack -> subscriptionPack.getDescription() + ": " + subscriptionPack.getId())
                        .collect(Collectors.joining(", "))));

        int subscriptionId = scanner.nextInt();
        LOGGER.info("Enter the months: ");
        int months = scanner.nextInt();
        calculateSubscription(subscriptionId, months);
    }

    private void calculateSubscription(int subscriptionId, int months) {
        User user = userDao.findById(Constants.LOGGED_IN_USER_ID);
        SubscriptionPack subscriptionPack = subscriptionPackDao.findById(subscriptionId);
        LOGGER.info(String.format("Monthly Price: %s Rs.", subscriptionPack.getPrice()));
        LOGGER.info(String.format("Number of Months: %s", months));

        int subscriptionAmount = subscriptionPack.getPrice() * months;
        LOGGER.info(String.format("Subscription amount: %s Rs.", subscriptionAmount));

        int discount = this.promoService.getDiscount(Constants.LOGGED_IN_USER_ID);
        LOGGER.info(String.format("Discount applied: %s Rs.", discount));

        int finalPrice = subscriptionAmount - discount;
        LOGGER.info(String.format("Final price after discount: %s Rs.", finalPrice));

        if (user.getSubscriptionPacks()!= null &&
                user.getSubscriptionPacks().stream().anyMatch(sp -> sp.getId() == subscriptionId)) {
            LOGGER.info(String.format("Sorry you already have subscribed to the same pack: %s", subscriptionPack.getDescription()));
            return;
        }
        updateUser(user, subscriptionPack, finalPrice);
    }

    private void updateUser(User user, SubscriptionPack subscriptionPack, int finalPrice) {
        if (user.getAccountBalance() > finalPrice) {
            user.setAccountBalance(user.getAccountBalance() - finalPrice);
            if (user.getSubscriptionPacks() != null) {
                user.getSubscriptionPacks().add(subscriptionPack);
            } else {
                user.setSubscriptionPacks(Collections.singletonList(subscriptionPack));
            }
            userDao.save(user);
            LOGGER.info(String.format("Account balance: %s Rs.", user.getAccountBalance()));
            LOGGER.info(String.format("You have successfully subscribed the following packs. %s", subscriptionPack.getDescription()));
            this.notificationService.sendEmailAndSMSNotification(user.getId());
        } else {
            LOGGER.info(String.format("Insufficiant account balance to subscribe the pack. Account Bal: %s Rs.", user.getAccountBalance()));
        }
    }
}
