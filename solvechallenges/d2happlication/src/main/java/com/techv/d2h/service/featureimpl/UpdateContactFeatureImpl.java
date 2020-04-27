package com.techv.d2h.service.featureimpl;

import com.techv.d2h.model.User;
import com.techv.d2h.util.Constants;

public class UpdateContactFeatureImpl extends AbstractFeatureImpl {
    @Override
    public void process() {
        User user = userDao.findById(Constants.LOGGED_IN_USER_ID);
        LOGGER.info("Update email and phone number for notifications.");
        LOGGER.info("Enter the email: ");
        String email = scanner.nextLine();
        LOGGER.info("Enter phone: ");
        String phone = scanner.nextLine();
        user.setEmailId(email);
        user.setPhone(phone);
        userDao.save(user);
        LOGGER.info("Email and Phone updated successfully.");
    }
}
