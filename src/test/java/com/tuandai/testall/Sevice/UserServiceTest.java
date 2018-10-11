package com.tuandai.testall.Sevice;

import com.tuandai.testall.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user=new User();
        user.setId(4);
        user.setAmount(120L);
        user.setName("李四");
        userService.addUser(user);
    }
}