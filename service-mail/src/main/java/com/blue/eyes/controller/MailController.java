package com.blue.eyes.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blue.eyes.aspect.logger.SysLogger;
import com.blue.eyes.dto.AddMSDto;
import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.dto.UptMSDto;
import com.blue.eyes.entity.mail.MailSend;
import com.blue.eyes.group.GroupAdd;
import com.blue.eyes.model.CommonResult;
import com.blue.eyes.model.LoggerTypeEnum;
import com.blue.eyes.service.MlService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "邮件接口", description = "邮件处理")
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MlService mlService;

    @ApiOperation("添加邮件发送记录")
    @SysLogger(desc = "添加邮件发送记录", type = "2-1")
    @PostMapping("/addMailSend")
    public CommonResult addMailSend(@RequestBody @Validated(value = GroupAdd.class) AddMSDto msDto){
        boolean addResult = mlService.addMailSend(msDto);
        if(addResult){
            return ResponseMgr.success("添加成功");
        }
        return ResponseMgr.fail("添加失败");
    }

    @ApiOperation("查询邮件发送记录")
    @SysLogger(desc = "查询邮件发送记录", type = "0-0")
    @PostMapping("/getMailSendList")
    public CommonResult getMailSendList(@RequestBody @Validated(value = GroupAdd.class) SelMSDto msDto){
        IPage<MailSend> pageInfo = mlService.getMailSendList(msDto);
        return ResponseMgr.successWithData(pageInfo);
    }

    @ApiOperation("更新邮件发送记录")
    @SysLogger(desc = "更新邮件发送记录", type = "0-0")
    @PostMapping("/uptMailSend")
    public CommonResult uptMailSend(@RequestBody @Validated(value = GroupAdd.class) UptMSDto msDto){
        boolean uptResult = mlService.uptMailSend(msDto);
        if(uptResult){
            return ResponseMgr.success("修改成功");
        }
        return ResponseMgr.fail("修改失败");
    }
}
