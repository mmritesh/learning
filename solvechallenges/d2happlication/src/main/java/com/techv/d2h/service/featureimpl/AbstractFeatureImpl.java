package com.techv.d2h.service.featureimpl;

import com.techv.d2h.dao.ChannelDao;
import com.techv.d2h.dao.ServicePackDao;
import com.techv.d2h.dao.SubscriptionPackDao;
import com.techv.d2h.dao.UserDao;
import com.techv.d2h.dao.impl.ChannelDaoImpl;
import com.techv.d2h.dao.impl.ServicePackDaoImpl;
import com.techv.d2h.dao.impl.SubscriptionPackDaoImpl;
import com.techv.d2h.dao.impl.UserDaoImpl;
import com.techv.d2h.service.FeatureService;
import com.techv.d2h.service.Logger;
import com.techv.d2h.service.NotificationService;
import com.techv.d2h.service.PromoService;
import com.techv.d2h.service.impl.LoggerImpl;
import com.techv.d2h.service.impl.NotificationServiceImpl;
import com.techv.d2h.service.impl.PromoServiceImpl;

import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class AbstractFeatureImpl implements FeatureService {

    protected static final Logger LOGGER = new LoggerImpl();

    protected SubscriptionPackDao subscriptionPackDao;
    protected UserDao userDao;
    protected Scanner scanner;
    protected ServicePackDao servicePackDao;
    protected ChannelDao channelDao;
    protected NotificationService notificationService;
    protected PromoService promoService;

    public AbstractFeatureImpl() {
        this.subscriptionPackDao = new SubscriptionPackDaoImpl();
        this.userDao = new UserDaoImpl();
        this.scanner = new Scanner(new InputStreamReader(System.in));
        this.promoService = new PromoServiceImpl();
        this.notificationService = new NotificationServiceImpl();
        this.servicePackDao = new ServicePackDaoImpl();
        this.channelDao = new ChannelDaoImpl();
    }
}
