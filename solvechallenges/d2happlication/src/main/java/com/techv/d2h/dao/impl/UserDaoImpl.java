package com.techv.d2h.dao.impl;

import com.techv.d2h.dao.UserDao;
import com.techv.d2h.model.User;

import static com.techv.d2h.db.InMemoryDb.USERS;

public class UserDaoImpl implements UserDao {

    @Override
    public User findById(int id) {
        return USERS.get(id);
    }

    @Override
    public User updateAccuntBalance(int id, int amount) {
        User user = findById(id);
        user.setAccountBalance(user.getAccountBalance() + amount);
        return user;
    }

    @Override
    public User save(User user) {
        User dbUser = findById(user.getId());
        if (dbUser != null) {
            dbUser.setAccountBalance(user.getAccountBalance());
            dbUser.setNoOfMonths(user.getNoOfMonths());
            dbUser.setServicePacks(user.getServicePacks());
            dbUser.setSubscriptionPacks(user.getSubscriptionPacks());
        } else {
            USERS.add(user);
        }
        return dbUser;
    }
}
