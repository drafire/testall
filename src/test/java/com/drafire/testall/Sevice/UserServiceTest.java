package com.drafire.testall.Sevice;

import com.drafire.testall.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    //@Test
    public void addUser() {
        User user=new User();
        user.setId(1);
        user.setAmount(110L);
        user.setName("李四");
        userService.add(user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.update(user);
    }

    @Test
    public void prepare(){
        User user=new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.prepare(user);
    }

    @Test
    public void setParameters(){
        User user=new User();
        user.setId(1);
        user.setAmount(50L);
        user.setName("王五123");
        userService.setParameters(user);
    }
}