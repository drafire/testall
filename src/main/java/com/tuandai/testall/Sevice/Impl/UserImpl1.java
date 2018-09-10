package com.tuandai.testall.Sevice.Impl;

import com.tuandai.testall.Sevice.User;
import org.springframework.stereotype.Service;

@Service
public class UserImpl1 implements User {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
