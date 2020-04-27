package com.techv.d2h.service.featureimpl;

import com.techv.d2h.util.Constants;

public class ViewBalanceFeatureImpl extends AbstractFeatureImpl {

    @Override
    public void process() {
        LOGGER.info(String.format("Current balance is %s Rs.", userDao.findById(Constants.LOGGED_IN_USER_ID).getAccountBalance()));
    }
}
