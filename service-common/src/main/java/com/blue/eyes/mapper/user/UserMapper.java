package com.blue.eyes.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blue.eyes.dto.user.SelUserDto;
import com.blue.eyes.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> getPageList(@Param("iPage") IPage<User> iPage, @Param("userDto") SelUserDto userDto);
}