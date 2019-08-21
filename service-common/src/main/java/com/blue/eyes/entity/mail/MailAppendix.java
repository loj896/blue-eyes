package com.blue.eyes.entity.mail;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName(value = "t_mail_appendix")
public class MailAppendix implements Serializable {

    @TableId
    private String appendixId;

    private String sendId;

    private String fileId;

    public String getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(String appendixId) {
        this.appendixId = appendixId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}