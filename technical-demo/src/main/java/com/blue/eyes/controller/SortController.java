package com.blue.eyes.controller;

import com.blue.eyes.aspect.logger.SysLogger;
import com.blue.eyes.enums.SortTypeEnum;
import com.blue.eyes.group.GroupAdd;
import com.blue.eyes.model.CommonResult;
import com.blue.eyes.sort.dto.BubbleSortDto;
import com.blue.eyes.sort.service.BubbleSortService;
import com.blue.eyes.util.ResponseMgr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-06 13:39
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
@Api(value = "排序", description = "排序")
@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private BubbleSortService bubbleSortService;

    /**
     * 冒泡排序
     * @param sortDto
     * @return
     */
    @PostMapping("/bubbleSort")
    @ApiOperation("冒泡排序")
    @SysLogger(desc = "冒泡排序", type = "0-0")
    public CommonResult bubbleSort(@RequestBody @Validated(value = GroupAdd.class) BubbleSortDto sortDto){
        if(SortTypeEnum.exist(sortDto.getSort())){
            Integer[] sortList = null;
            if(SortTypeEnum.SORT_ASC.getSort() == sortDto.getSort()){
                sortList = bubbleSortService.sortAsc(sortDto.getNums());
            }else {
                sortList = bubbleSortService.sortDesc(sortDto.getNums());
            }
            return ResponseMgr.successWithData(sortList);
        }
        return ResponseMgr.fail("排序方式只能为1或2");
    }
}
