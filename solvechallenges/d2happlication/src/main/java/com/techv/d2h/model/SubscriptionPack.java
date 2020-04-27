package com.techv.d2h.model;

import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionPack {
    private int id;
    private String description;
    private int price;
    private List<Channel> channels;

    public SubscriptionPack(int id, String description, int price, List<Channel> channels) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.channels = channels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return description + ": " +
                String.join(", ", channels.stream().map(Channel::getName).collect(Collectors.toList())) + ": " +
                price + "Rs.";
    }
}
