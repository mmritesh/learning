package com.techv.d2h.model;

import java.util.List;

public class User {
    private int id;
    private int accountBalance;
    private List<SubscriptionPack> subscriptionPacks;
    private List<ServicePack> servicePacks;
    private int noOfMonths;
    private List<Channel> channels;
    private String emailId;
    private String phone;

    public User(int id, int accountBalance) {
        this.id = id;
        this.accountBalance = accountBalance;
    }

    public User(int id, int accountBalance, List<SubscriptionPack> subscriptionPacks, List<ServicePack> servicePacks, int noOfMonths) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.subscriptionPacks = subscriptionPacks;
        this.servicePacks = servicePacks;
        this.noOfMonths = noOfMonths;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<SubscriptionPack> getSubscriptionPacks() {
        return subscriptionPacks;
    }

    public void setSubscriptionPacks(List<SubscriptionPack> subscriptionPacks) {
        this.subscriptionPacks = subscriptionPacks;
    }

    public List<ServicePack> getServicePacks() {
        return servicePacks;
    }

    public void setServicePacks(List<ServicePack> servicePacks) {
        this.servicePacks = servicePacks;
    }

    public int getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(int noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
