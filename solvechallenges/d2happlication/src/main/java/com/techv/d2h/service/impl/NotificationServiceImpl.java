package com.techv.d2h.service.impl;

import com.techv.d2h.service.Logger;
import com.techv.d2h.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {
    private static final Logger LOGGER = new LoggerImpl();

    @Override
    public boolean sendEmailNotification(int userId) {
        LOGGER.info("Email notification sent successfully.");
        return true;
    }

    @Override
    public boolean sendSMSNotification(int userId) {
        LOGGER.info("SMS notification sent successfully.");
        return true;
    }

    @Override
    public boolean sendEmailAndSMSNotification(int userId) {
        return sendEmailNotification(userId) && sendSMSNotification(userId);
    }
}
