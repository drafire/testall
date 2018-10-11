package com.tuandai.testall.Sevice;

import com.tuandai.testall.dao.UserMapper;
import com.tuandai.testall.model.User;
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
