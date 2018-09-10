package com.tuandai.testall.Sevice.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserImpl1Test {

    @Autowired
    private UserImpl1 userImpl1;        //不需要使用扫描，只需要用@Service就行了。因为启动项：TestallApplication 的注解已经包含了@ComponentScan了
    @Test
    public void addUser() {
        userImpl1.addUser();
    }
}