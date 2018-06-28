package com.sheamus.learn.service.impl;

import com.sheamus.learn.dao.UserMapper;
import com.sheamus.learn.domain.User;
import com.sheamus.learn.domain.UserExample;
import com.sheamus.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sheamus on 2018/6/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        int insert = userMapper.insert(user);
        if(insert == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public User getUserById(String id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() != 0) {
            return users.get(0);
        }
        return null;
    }
}
