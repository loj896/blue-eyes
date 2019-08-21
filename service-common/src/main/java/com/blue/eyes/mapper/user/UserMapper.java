package com.blue.eyes.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.eyes.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}