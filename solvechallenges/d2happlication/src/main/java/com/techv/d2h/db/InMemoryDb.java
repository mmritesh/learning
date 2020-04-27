package com.techv.d2h.db;

import com.techv.d2h.model.Channel;
import com.techv.d2h.model.Feature;
import com.techv.d2h.model.ServicePack;
import com.techv.d2h.model.SubscriptionPack;
import com.techv.d2h.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryDb {

    public static List<Feature> FEATURES = Arrays.asList(
            new Feature(1, "ViewBalance", "View current balance in the account."),
            new Feature(2, "Recharge", "Recharge Account."),
            new Feature(3, "ViewAvailablePacks", "View available packs, channels and services."),
            new Feature(4, "SubscribeToBasePack", "Subscribe to base packs."),
            new Feature(5, "AddChannelsToSubscription", "Add channels to an existing subscription."),
            new Feature(6, "SubscriptToSpeacialServices", "Subscribe to special services."),
            new Feature(7, "ViewSubscriptionDetails", "View current subscription details."),
            new Feature(8, "UpdateContact", "Update email and phone number for notifications."),
            new Feature(9, "Exit", "Exit.")
    );

    public static List<User> USERS = Arrays.asList(new User(0, 100));

    public static List<Channel> CHANNELS = Arrays.asList(
            new Channel(0, "Zee", 10),
            new Channel(1, "Sony", 15),
            new Channel(2, "Star Plus", 20),
            new Channel(3, "Discovery", 10),
            new Channel(4, "NatGeo", 20)
    );

    public static Map<Integer, List<Integer>> subscriptionPackToChannelMapping = new HashMap<Integer, List<Integer>>(){{
        put(0, Arrays.asList(0, 1, 2));
        put(1, Arrays.asList(0, 1, 2, 3, 4));
    }};

    public static List<SubscriptionPack> SUBSCRIPTION_PACKS = Arrays.asList(
            new SubscriptionPack(0, "Silver Pack", 50,
                    subscriptionPackToChannelMapping.get(0).stream().map(id -> CHANNELS.get(id)).collect(Collectors.toList())),
            new SubscriptionPack(1, "Gold Pack", 100,
                    subscriptionPackToChannelMapping.get(1).stream().map(id -> CHANNELS.get(id)).collect(Collectors.toList()))
    );

    public static List<ServicePack> SERVICE_PACKS = Arrays.asList(
            new ServicePack(0, "LearnEnglish Service", 200),
            new ServicePack(1, "LearnCooking Service", 100)
    );

}
