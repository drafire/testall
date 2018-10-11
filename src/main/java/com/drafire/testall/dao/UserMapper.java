package com.drafire.testall.dao;

import com.drafire.testall.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    int update(User user);
}