package com.techv.d2h.service;

public interface NotificationService {
    boolean sendEmailNotification(int userId);
    boolean sendSMSNotification(int userId);
    boolean sendEmailAndSMSNotification(int userId);
}
