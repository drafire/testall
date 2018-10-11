package com.drafire.testall.Sevice;

import com.drafire.testall.dao.UserMapper;
import com.drafire.testall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user){
        userMapper.insert(user);
    }
}
