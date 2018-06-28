package com.sheamus.learn.controller;

import com.sheamus.learn.base.BaseResult;
import com.sheamus.learn.domain.User;
import com.sheamus.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sheamus on 2018/6/28.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ResponseBody
    public BaseResult addUser(@RequestBody User user) {
        boolean b = userService.addUser(user);
        if(b) {
            return BaseResult.OK(null);
        } else {
            return BaseResult.fail();
        }
    }

    @PostMapping("/getAllUser")
    @ResponseBody
    public BaseResult getAllUser() {
        List<User> users = userService.getAllUser();
        return BaseResult.OK(users);
    }
}
