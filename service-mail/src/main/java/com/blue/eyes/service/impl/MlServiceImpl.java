package com.blue.eyes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blue.eyes.dto.AddMSDto;
import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.dto.UptMSDto;
import com.blue.eyes.entity.mail.MailSend;
import com.blue.eyes.service.MlService;
import com.blue.eyes.service.mail.MailSendService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class MlServiceImpl implements MlService {

    @Resource
    private MailSendService mailSendService;

    @Override
    public IPage<MailSend> getMailSendList(SelMSDto msDto) {
        QueryWrapper<MailSend> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(msDto.getSendId())){
            wrapper.eq("send_id", msDto.getSendId());
        }
        if(StringUtils.isNotEmpty(msDto.getSendEmail())){
            wrapper.like("send_email", msDto.getSendEmail());
        }
        if(StringUtils.isNotEmpty(msDto.getEmailSubject())){
            wrapper.like("email_subject", msDto.getEmailSubject());
        }
        if(StringUtils.isNotEmpty(msDto.getEmailContent())){
            wrapper.like("email_content", msDto.getEmailContent());
        }
        if(StringUtils.isNotEmpty(msDto.getReceiveEmail())){
            wrapper.like("receive_email", msDto.getReceiveEmail());
        }
        if(StringUtils.isNotEmpty(msDto.getMailStatus())){
            wrapper.eq("mail_status", msDto.getMailStatus());
        }
        long current = msDto.getCurrent();
        long pageSize = msDto.getPageSize();
        return mailSendService.page(new Page<>(current, pageSize), wrapper);
    }

    @Override
    public boolean addMailSend(AddMSDto msDto) {
        MailSend mailSend = new MailSend();
        BeanUtils.copyProperties(msDto, mailSend);
        mailSend.setCreateDate(new Date());
        return mailSendService.save(mailSend);
    }

    @Override
    public boolean uptMailSend(UptMSDto msDto) {
        MailSend mailSend = new MailSend();
        BeanUtils.copyProperties(msDto, mailSend);
        return mailSendService.updateById(mailSend);
    }

    @Override
    public boolean delMailSend(List<String> msIds) {
        return mailSendService.removeByIds(msIds);
    }
}
