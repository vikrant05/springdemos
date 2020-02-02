package com.vikrant.springboot.login.dao;

import com.vikrant.springboot.login.model.User;

public interface UserDao {
    User getUser(String userName) throws Exception;

    void addUser(User user);
}
