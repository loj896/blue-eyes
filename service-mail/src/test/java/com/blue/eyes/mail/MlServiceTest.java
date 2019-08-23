package com.blue.eyes.mail;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blue.eyes.dto.AddMSDto;
import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.dto.UptMSDto;
import com.blue.eyes.entity.mail.MailSend;
import com.blue.eyes.service.MlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-08-23 13:37
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
public class MlServiceTest {

    @Resource
    private MlService mlService;

    /**
     * 添加邮件发送记录
     */
    @Test
    public void addMailSend(){
        AddMSDto msDto = new AddMSDto();
        msDto.setSendEmail("123@123.com");
        msDto.setEmailSubject("邮件记录测试");
        msDto.setEmailContent("测试测试");
        msDto.setReceiveEmail("234@234.com");
        msDto.setCreateId("00");
        msDto.setMailStatus("1");
        boolean addResult = mlService.addMailSend(msDto);
        if(addResult){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    /**
     * 修改邮件发送记录
     */
    @Test
    public void uptMailSend(){
        UptMSDto msDto = new UptMSDto();
        msDto.setSendId("f510f96f27a15abbe54d8bd8d7969545");
        msDto.setEmailContent("测试吧");
        boolean uptResult = mlService.uptMailSend(msDto);
        if(uptResult){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询邮件发送记录
     */
    @Test
    public void getMailSendList(){
        SelMSDto msDto = new SelMSDto();
        msDto.setEmailSubject("测试");
        msDto.setCurrent(1);
        msDto.setPageSize(5);
        IPage<MailSend> pageInfo = mlService.getMailSendList(msDto);
        List<MailSend> sendList = pageInfo.getRecords();
        if(null != sendList && sendList.size()>0){
            for (MailSend mailSend : sendList){
                System.out.println("mailId："+mailSend.getSendId()+"，emailSubject："+mailSend.getEmailSubject());
            }
        }
    }
}
