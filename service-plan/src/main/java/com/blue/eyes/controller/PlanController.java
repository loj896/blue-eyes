package com.blue.eyes.controller;

import com.blue.eyes.aspect.logger.SysLogger;
import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.group.GroupAdd;
import com.blue.eyes.model.CommonResult;
import com.blue.eyes.service.PlanService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-04 12:28
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
@Api(tags = "计划接口", description = "计划任务")
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @ApiOperation("添加计划/任务")
    @SysLogger(desc = "添加计划/任务", type = "0-0")
    @PostMapping("/addPlan")
    public CommonResult addPlan(@RequestBody @Validated(value = GroupAdd.class) SelMSDto msDto){
        boolean addResult = planService.addPlan(msDto);
        if(addResult){
            return ResponseMgr.success("添加成功");
        }
        return ResponseMgr.fail("添加失败");
    }

    @ApiOperation("Hello")
    @GetMapping("/hello")
    public CommonResult hello(@ApiParam(value = "姓名") @RequestParam(required = false) String name){
        return ResponseMgr.successWithData("hello "+name+", this is plan service.");
    }


}
