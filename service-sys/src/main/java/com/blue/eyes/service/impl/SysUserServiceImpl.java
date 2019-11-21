package com.blue.eyes.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.eyes.dto.AddUserDto;
import com.blue.eyes.dto.UptUserDto;
import com.blue.eyes.dto.user.SelUserDto;
import com.blue.eyes.entity.user.User;
import com.blue.eyes.service.SysUserService;
import com.blue.eyes.service.user.UserService;
import com.blue.eyes.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-22 9:42
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
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private UserService userService;

    @Override
    public IPage<User> getPageList(SelUserDto userDto) {
        long current = userDto.getCurrent() == 0 ? 1 : userDto.getCurrent();
        long pageSize = userDto.getPageSize() == 0 ? 5 : userDto.getPageSize();
        return userService.getPageList(new Page<>(current, pageSize), userDto);
    }

    @Override
    public boolean addUser(List<AddUserDto> userList) {
        if(CollectionUtils.isEmpty(userList)){
            return false;
        }
        List<User> addList = new ArrayList<>();
        User user = null;
        Date nowDate = new Date();
        for (AddUserDto userDto : userList){
            user = new User();
            BeanUtils.copyProperties(userDto, user);
            user.setUserId(StringUtil.lowerUUID32());
            user.setUserStatus("1");
            user.setAddDate(nowDate);
            user.setUptDate(nowDate);
            addList.add(user);
        }
        return userService.saveBatch(addList);
    }

    @Override
    public boolean uptUser(List<UptUserDto> userList) {
        List<User> uptList = new ArrayList<>();
        User user = null;
        Date nowDate = new Date();
        for (UptUserDto userDto : userList) {
            user = new User();
            BeanUtils.copyProperties(userDto, user);
            user.setUptDate(nowDate);
            uptList.add(user);
        }
        return userService.updateBatchById(uptList);
    }

    @Override
    public boolean delUser(List<String> userIds) {
        return userService.removeByIds(userIds);
    }
}
