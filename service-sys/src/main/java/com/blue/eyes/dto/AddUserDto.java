package com.blue.eyes.dto;

import com.blue.eyes.group.GroupAdd;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-21 10:05
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
public class AddUserDto{

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    /**
     * 用户级别
     */
    @NotBlank(message = "用户级别不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "用户级别", name = "levelCode")
    private String levelCode;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "真实姓名", name = "realName")
    private String realName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
