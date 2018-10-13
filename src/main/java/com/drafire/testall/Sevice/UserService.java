package com.drafire.testall.Sevice;

import com.drafire.testall.dao.UserMapper;
import com.drafire.testall.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public void add(User user) {
        userMapper.insert(user);
    }

    public void update(User user) {
        int res = userMapper.update(user);
        System.out.println("res=" + res);
    }

    public void prepare(User user) {
        int res = userMapper.update(user);
    }

    public void setParameters(User user) {
        int res = userMapper.update(user);
    }

    public User getUser(int id) {
        return userMapper.select(id);
    }

    public void getUserBySqlSession(int id) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(id);
        sqlSession.close();
        logger.info("{}", user);
    }
}
