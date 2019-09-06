package com.blue.eyes.sort.service.impl;

import com.blue.eyes.sort.service.BubbleSortService;
import org.springframework.stereotype.Service;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-06 13:52
 *           '::::::::::::'           @description 冒泡排序业务实现类
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
public class BubbleSortServiceImpl implements BubbleSortService {

    @Override
    public Integer[] sortAsc(Integer[] ary) {
        for (int i = 0; i < ary.length - 1; i++) {
            for (int j = 0; j < ary.length - i - 1; j++) {
                int temp = ary[j];
                if (ary[j] > ary[j + 1]) {
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                }
            }
        }
        return ary;
    }

    @Override
    public Integer[] sortDesc(Integer[] ary) {
        for(int i = 0; i< ary.length - 1; i++) {
            for(int j = 0;j< ary.length - i -1;j++) {
                if(ary[j] < ary[j+1]) {
                    int temp = ary[j];
                    ary[j] = ary[j+1];
                    ary[j+1] = temp;
                }
            }
        }
        return ary;
    }
}
