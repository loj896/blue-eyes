package com.blue.eyes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blue.eyes.entity.user.User;
import com.blue.eyes.service.UService;
import com.blue.eyes.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-03 16:46
 *           '::::::::::::'           @description
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@Service
public class UserServiceImpl implements UService {

    @Resource
    private UserService userService;

    @Override
    public User loadUserByUsername(String username) {
        QueryWrapper<User> querWapper = new QueryWrapper<>();
        querWapper.eq("user_name", username);
        querWapper.eq("user_status", "1");
        return userService.getOne(querWapper);
    }
}
