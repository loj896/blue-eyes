package com.blue.eyes.dto.user;

import com.blue.eyes.model.PageDto;
import io.swagger.annotations.ApiModelProperty;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-21 10:00
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
public class SelUserDto extends PageDto {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户ID", name = "userId")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    /**
     * 用户级别
     */
    @ApiModelProperty(value = "用户级别", name = "levelCode")
    private String levelCode;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", name = "realName")
    private String realName;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", name = "userStatus")
    private String userStatus;

    /**
     * 查询标识
     */
    @ApiModelProperty(value = "查询标识（1：搜索，2：修改校验查询，3：新增校验查询）", name = "selFlag")
    private Integer selFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getSelFlag() {
        return selFlag;
    }

    public void setSelFlag(Integer selFlag) {
        this.selFlag = selFlag;
    }
}
