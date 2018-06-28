package com.sheamus.learn.service;

import com.sheamus.learn.domain.User;

import java.util.List;

/**
 * Created by Sheamus on 2018/6/28.
 */
public interface UserService {
    boolean addUser(User user);
    List<User> getAllUser();
    User getUserById(String id);
}
