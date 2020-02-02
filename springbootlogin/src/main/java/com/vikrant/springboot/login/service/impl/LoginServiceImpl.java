package com.vikrant.springboot.login.service.impl;

import com.vikrant.springboot.login.dao.UserDao;
import com.vikrant.springboot.login.model.User;
import com.vikrant.springboot.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userName) throws Exception {
        return userDao.getUser(userName);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
