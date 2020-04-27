package com.techv.d2h.service.featureimpl;

import com.techv.d2h.model.ServicePack;
import com.techv.d2h.model.User;
import com.techv.d2h.util.Constants;

import java.util.ArrayList;

public class SubscriptToSpeacialServicesFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        servicePackDao.findAll().forEach(servicePack -> {
            LOGGER.info(String.format("%s. %s : %s Rs.", servicePack.getId(), servicePack.getDescription(), servicePack.getPrice()));
        });
        LOGGER.info("Enter the service pack id: ");
        int choice = scanner.nextInt();
        User user = userDao.findById(Constants.LOGGED_IN_USER_ID);


        if (user.getServicePacks() != null && user.getServicePacks().stream().anyMatch(servicePack -> servicePack.getId() == choice)) {
            LOGGER.info("Already subscribed to this pack.");
            return;
        }

        if (user.getServicePacks() == null) {
            user.setServicePacks(new ArrayList<>());
        }

        ServicePack servicePack = servicePackDao.findById(choice);

        user.getServicePacks().add(servicePack);
        int totalPrice = servicePack.getPrice();

        if (totalPrice > user.getAccountBalance()) {
            LOGGER.info(String.format("Insufficiant account balance. Current Bal: %s Rs.", user.getAccountBalance()));
            return;
        }
        user.setAccountBalance(user.getAccountBalance() - totalPrice);
        userDao.save(user);

        LOGGER.info("Service subscribed successfully");
        LOGGER.info(String.format("Account balance: %s Rs.", user.getAccountBalance()));
        notificationService.sendEmailAndSMSNotification(user.getId());
    }
}
