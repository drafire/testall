package com.drafire.testall.Sevice;

import com.drafire.testall.dao.UserMapper;
import com.drafire.testall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void add(User user){
        userMapper.insert(user);
    }

    public void update(User user){
       int res= userMapper.update(user);
       System.out.println("res="+res);
    }

    public void prepare(User user){
        int res= userMapper.update(user);
    }

    public void setParameters(User user){
        int res= userMapper.update(user);
    }

    public User getUser(int id){
        return userMapper.select(id);
    }
}
