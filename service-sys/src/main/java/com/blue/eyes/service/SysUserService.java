package com.blue.eyes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blue.eyes.dto.AddUserDto;
import com.blue.eyes.dto.UptUserDto;
import com.blue.eyes.dto.user.SelUserDto;
import com.blue.eyes.entity.user.User;

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
public interface SysUserService {

    /**
     * 分页查询用户信息
     * @param userDto
     * @return
     */
    IPage<User> getPageList(SelUserDto userDto);

    /**
     * 新增用户信息
     * @param userList
     * @return
     */
    boolean addUser(List<AddUserDto> userList);

    /**
     * 修改用户记录
     * @param userList
     * @return
     */
    boolean uptUser(List<UptUserDto> userList);

    /**
     * 删除用户信息
     * @param userIds
     * @return
     */
    boolean delUser(List<String> userIds);
}
