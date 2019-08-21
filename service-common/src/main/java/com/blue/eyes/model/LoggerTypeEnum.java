package com.blue.eyes.model;

/*** 
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-07-19 15:08
 *           '::::::::::::'           @description 日志类型枚举
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
public enum LoggerTypeEnum {
    /**
     * 其他类型
     */
    ELSE_TYPE("0-0"),
    /**
     * 文件上传
     */
    FILE_UPLOAD("1-1"),
    /**
     * 文件下载
     */
    FILE_DOWNLOAD("1-2"),
    /**
     * 邮件发送
     */
    MAIL_SEND("2-1");

    LoggerTypeEnum(String type){
        this.type = type;
    }
    String type;

    public String getType() {
        return type;
    }

    public static LoggerTypeEnum getType(String type) {
        LoggerTypeEnum[] values = LoggerTypeEnum.values();
        for (LoggerTypeEnum outType : values) {
            if (outType.getType().equals(type)) {
                return outType;
            }
        }
        return null;
    }
}
