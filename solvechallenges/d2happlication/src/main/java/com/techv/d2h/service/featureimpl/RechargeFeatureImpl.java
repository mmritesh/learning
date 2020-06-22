package com.techv.d2h.service.featureimpl;

import com.techv.d2h.model.User;
import com.techv.d2h.util.Constants;

public class RechargeFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        LOGGER.info("Enter discount to recharge: ");
        int amount = scanner.nextInt();
        User user = userDao.updateAccuntBalance(Constants.LOGGED_IN_USER_ID, amount);
        LOGGER.info(String.format("Recharge completed successfully. Current balance is: %s", user.getAccountBalance()));

    }
}
