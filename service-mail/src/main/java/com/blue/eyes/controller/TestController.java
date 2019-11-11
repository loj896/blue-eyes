package com.blue.eyes.controller;

import com.blue.eyes.model.CommonResult;
import com.blue.eyes.service.TestService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("熔断器测试-后端异常处理")
    @PostMapping("/hystrixtError")
    public CommonResult hystrixtError(@RequestBody String name) throws Exception {
        String msg = testService.hystrixtError(name);
        return ResponseMgr.successWithData(msg);
    }

    @ApiOperation("熔断器测试-正常")
    @PostMapping("/hystrixNormal")
    public CommonResult hystrixNormal(@RequestBody String name) throws Exception {
        String msg = testService.hystrixNormal(name);
        return ResponseMgr.successWithData(msg);
    }
}
