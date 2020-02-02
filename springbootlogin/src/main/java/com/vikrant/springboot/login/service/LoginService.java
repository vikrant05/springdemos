package com.vikrant.springboot.login.service;

import com.vikrant.springboot.login.model.User;
import org.springframework.stereotype.Service;


@Service
public interface LoginService {
    User getUser(String userName) throws Exception;

    void addUser(User user);
}
