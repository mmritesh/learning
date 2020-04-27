package com.techv.d2h.dao;

import com.techv.d2h.model.User;

public interface UserDao {
    User findById(int id);
    User updateAccuntBalance(int id, int amount);
    User save(User user);
}
