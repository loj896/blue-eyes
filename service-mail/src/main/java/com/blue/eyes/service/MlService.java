package com.blue.eyes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blue.eyes.dto.AddMSDto;
import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.dto.UptMSDto;
import com.blue.eyes.entity.mail.MailSend;

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
public interface MlService {

    /**
     * 查询邮件发送记录
     * @param msDto
     * @return
     */
    IPage<MailSend> getMailSendList(SelMSDto msDto);

    /**
     * 新增邮件发送记录
     * @param msDto
     * @return
     */
    boolean addMailSend(AddMSDto msDto);

    /**
     * 修改邮件发送记录
     * @param msDto
     * @return
     */
    boolean uptMailSend(UptMSDto msDto);

    /**
     * 删除邮件发送记录
     * @param msIds
     * @return
     */
    boolean delMailSend(List<String> msIds);
}
