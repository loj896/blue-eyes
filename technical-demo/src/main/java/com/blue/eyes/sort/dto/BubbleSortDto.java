package com.blue.eyes.sort.dto;

import com.blue.eyes.group.GroupAdd;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-06 13:44
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
public class BubbleSortDto {

    /**
     * 排序数组（数字）
     */
    @NotEmpty(message = "排序数组（数字）不能为空", groups = GroupAdd.class)
    @ApiModelProperty(value = "排序（1：升序，2：降序）", name = "sort")
    private Integer[] nums;

    /**
     * 排序方式（1：升序，2：降序）
     */
    @ApiModelProperty(value = "排序方式（1：升序，2：降序）", name = "sort")
    private Integer sort = 1;

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
