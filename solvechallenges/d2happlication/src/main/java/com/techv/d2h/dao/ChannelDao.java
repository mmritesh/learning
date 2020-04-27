package com.techv.d2h.dao;

import com.techv.d2h.model.Channel;

import java.util.List;

public interface ChannelDao {
    List<Channel> findAll();
    Channel findById(int id);
}
