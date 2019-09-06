package com.blue.eyes.dto.logger;


import com.blue.eyes.group.GroupAdd;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-13 10:17
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
@Document(collection = "logger")
public class LoggerDto {

    @Id
    private String id;

    /**
     * 日志类型
     */
    @Field("logType")
    private String loggerType;

    /**
     * 访问IP
     */
    @Field("ip")
    private String ip;

    /**
     * 用户ID
     */
    @NotBlank(message = "用户ID不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "用户ID", name = "userId")
    @Field("uId")
    private String userId;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "用户名称", name = "userName")
    @Field("uName")
    private String userName;

    /**
     * 访问时间
     */
    @Field("reqTime")
    private Date reqTime;

    /**
     * 访问地址
     */
    @NotBlank(message = "访问地址不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "访问地址", name = "reqURL")
    @Field("reqUrl")
    private String reqURL;

    /**
     * 说明
     */
    @Field("desc")
    private String desc;

    /**
     * 调用方法
     */
    @Field("method")
    private String method;

    /**
     * 参数
     */
    @Field("params")
    private String params;

    /**
     * 返回代码
     */
    @Field("restCode")
    private Integer restCode;

    /**
     * 返回结果
     */
    @Field("rest")
    private String rest;

    /**
     * 提示信息
     */
    @Field("msg")
    private String msg;

    /**
     * 耗时
     */
    private Long duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoggerType() {
        return loggerType;
    }

    public void setLoggerType(String loggerType) {
        this.loggerType = loggerType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

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

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public String getReqURL() {
        return reqURL;
    }

    public void setReqURL(String reqURL) {
        this.reqURL = reqURL;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getRestCode() {
        return restCode;
    }

    public void setRestCode(Integer restCode) {
        this.restCode = restCode;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
