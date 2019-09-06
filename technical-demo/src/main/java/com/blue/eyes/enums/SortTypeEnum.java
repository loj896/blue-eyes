package com.blue.eyes.enums;

import java.util.Arrays;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-06 13:59
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
public enum SortTypeEnum {

    /**
     * 升序
     */
    SORT_ASC(1),

    /**
     * 降序
     */
    SORT_DESC(2);

    private int sort;

    SortTypeEnum(int sort) {
        this.sort = sort;
    }

    public int getSort() {
        return sort;
    }

    public static boolean exist(Integer sort) {
        SortTypeEnum[] values = SortTypeEnum.values();
        return Arrays.stream(values).anyMatch(status -> status.getSort() == sort);
    }
}
