package com.techv.d2h.dao.impl;

import com.techv.d2h.dao.ChannelDao;
import com.techv.d2h.db.InMemoryDb;
import com.techv.d2h.model.Channel;

import java.util.List;

public class ChannelDaoImpl implements ChannelDao {

    @Override
    public List<Channel> findAll() {
        return InMemoryDb.CHANNELS;
    }

    @Override
    public Channel findById(int id) {
        return InMemoryDb.CHANNELS.get(id);
    }
}
