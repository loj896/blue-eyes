package com.blue.eyes.controller;

import com.blue.eyes.model.CommonResult;
import com.blue.eyes.service.TestService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-11 16:05
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
@Api(tags = "测试接口", description = "测试接口类")
@RestController
@RequestMapping("/mail/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("断路器测试-后端异常处理")
    @PostMapping("/hystrixtError")
    public CommonResult hystrixtError(@RequestBody String name) throws Exception {
        String msg = testService.hystrixtError(name);
        return ResponseMgr.successWithData(msg);
    }

    @ApiOperation("断路器测试-正常")
    @PostMapping("/hystrixNormal")
    public CommonResult hystrixNormal(@RequestBody String name) throws Exception {
        String msg = testService.hystrixNormal(name);
        return ResponseMgr.successWithData(msg);
    }

    @ApiOperation("Hello")
    @GetMapping("/hello")
    public CommonResult hello(@ApiParam(value = "姓名") @RequestParam(required = false) String name){
        return ResponseMgr.successWithData("hello "+name+", this is mail service.");
    }
}
