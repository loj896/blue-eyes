package com.blue.eyes.mapper.test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blue.eyes.entity.test.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<Test> {

}