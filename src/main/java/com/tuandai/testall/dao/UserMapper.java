package com.tuandai.testall.dao;

import com.tuandai.testall.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}