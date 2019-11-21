package com.blue.eyes.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.blue.eyes.dto.AddUserDto;
import com.blue.eyes.dto.UptUserDto;
import com.blue.eyes.dto.user.SelUserDto;
import com.blue.eyes.entity.user.User;
import com.blue.eyes.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-21 10:28
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private SysUserService userService;

    /**
     * 添加用户
     */
    @Test
    public void addUser(){
        List<AddUserDto> userList = new ArrayList<>();
        AddUserDto userDto = new AddUserDto();
        userDto.setLevelCode("1");
        userDto.setUserName("lh");
        userDto.setRealName("刘海");
        userDto.setPassword("222");
        userList.add(userDto);
        boolean addResult = userService.addUser(userList);
        if(addResult){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    /**
     * 修改用户信息
     */
    @Test
    public void uptUser(){
        List<UptUserDto> userList = new ArrayList<>();
        UptUserDto userDto = new UptUserDto();
        userDto.setUserId("");
        userDto.setPassword("222");
        userList.add(userDto);
        boolean uptResult = userService.uptUser(userList);
        if(uptResult){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询用户信息
     */
    @Test
    public void getMailSendList(){
        SelUserDto userDto = new SelUserDto();
        userDto.setUserName("l");
        userDto.setSelFlag(1);
        IPage<User> pageInfo = userService.getPageList(userDto);
        List<User> userList = pageInfo.getRecords();
        if(!CollectionUtils.isEmpty(userList)){
            for (User user : userList){
                System.out.println("userId："+user.getUserId()+"，userName："+user.getUserName()+"，realName："+user.getRealName());
            }
        }
    }
}
