package com.drafire.testall.controller;

import com.drafire.testall.Sevice.UserService;
import com.drafire.testall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "mybatis")
public class MybatisTestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test/cache/add")
    public void testAddCache(){
        User user = new User();
        user.setId(2);
        user.setAmount(110L);
        user.setName("王五");
        userService.add(user);
    }

    @RequestMapping(value = "/test/cache/get")
    public void testGetCache(){
        userService.getUser(2);
    }
}
