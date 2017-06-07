package com.yusute.web.controller;

import com.yusute.storage.model.User;
import com.yusute.storage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yusutehot
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String user(){
        User user = userService.loadUserById();
        logger.info("hello world, {}", user.getUsername());
        return "userinfo";
    }

    @RequestMapping("/update")
    public void update(){
        User user = new User();
        user.setId(1);
        user.setPassword("123");
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
