package com.drafire.testall.Sevice;

import com.drafire.testall.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setId(2);
        user.setAmount(110L);
        user.setName("李四");
        userService.add(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.update(user);
    }

    @Test
    public void prepare() {
        User user = new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.prepare(user);
    }

    @Test
    public void setParameters() {
        User user = new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.setParameters(user);
    }

    @Test
    public void getUser() {
        User user = userService.getUser(1);
    }

    @Test
    public void getUserBySqlSession() {
        try {
            userService.getUserBySqlSession(1);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}