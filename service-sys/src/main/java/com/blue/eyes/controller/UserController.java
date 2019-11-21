package com.blue.eyes.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.blue.eyes.aspect.logger.SysLogger;
import com.blue.eyes.dto.AddUserDto;
import com.blue.eyes.dto.UptUserDto;
import com.blue.eyes.dto.user.SelUserDto;
import com.blue.eyes.entity.user.User;
import com.blue.eyes.group.GroupAdd;
import com.blue.eyes.model.CommonResult;
import com.blue.eyes.service.SysUserService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-21 14:41
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
@Api(tags = "用户接口", description = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @ApiOperation("查询用户信息")
    @SysLogger(desc = "查询用户信息", type = "0-0")
    @PostMapping("/getUserList")
    public CommonResult getUserList(@RequestBody @Validated(value = GroupAdd.class) SelUserDto userDto){
        userDto.setSelFlag(1);
        IPage<User> pageInfo = userService.getPageList(userDto);
        return ResponseMgr.successWithData(pageInfo);
    }

    @ApiOperation("新增用户信息")
    @SysLogger(desc = "新增用户信息", type = "0-0")
    @PostMapping("/addUser")
    public CommonResult addUser(@RequestBody @Validated(value = GroupAdd.class) AddUserDto userDto){
        SelUserDto selDto = new SelUserDto();
        selDto.setUserName(userDto.getUserName());
        selDto.setSelFlag(3);
        IPage<User> pageInfo = userService.getPageList(selDto);
        if(!CollectionUtils.isEmpty(pageInfo.getRecords())){
            return ResponseMgr.fail("用户名已存在");
        }
        List<AddUserDto> addList = new ArrayList<>();
        addList.add(userDto);
        boolean addResult = userService.addUser(addList);
        if(addResult){
            return ResponseMgr.success("添加成功");
        }
        return ResponseMgr.fail("添加失败");
    }

    @ApiOperation("修改用户信息")
    @SysLogger(desc = "修改用户信息", type = "0-0")
    @PostMapping("/uptUser")
    public CommonResult uptUser(@RequestBody @Validated(value = GroupAdd.class) UptUserDto userDto){
        SelUserDto selDto = new SelUserDto();
        selDto.setUserId(userDto.getUserId());
        selDto.setUserName(userDto.getUserName());
        selDto.setSelFlag(2);
        IPage<User> pageInfo = userService.getPageList(selDto);
        if(!CollectionUtils.isEmpty(pageInfo.getRecords())){
            return ResponseMgr.fail("用户名已存在");
        }

        List<UptUserDto> uptList = new ArrayList<>();
        uptList.add(userDto);
        boolean uptResult = userService.uptUser(uptList);
        if(uptResult){
            return ResponseMgr.success("修改成功");
        }
        return ResponseMgr.fail("修改失败");
    }


}
