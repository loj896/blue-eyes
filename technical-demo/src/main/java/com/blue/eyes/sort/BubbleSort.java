package com.blue.eyes.sort;

import java.util.Scanner;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-05 22:33
 *           '::::::::::::'           @description 冒泡排序
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
public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] nums = str.split(",");
        Integer [] ascAry = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            ascAry[i] = Integer.valueOf(nums[i]);
        }
        Integer [] descAry = ascAry;

        sortAsc(ascAry);
        str = "";
        for (int i=0; i<ascAry.length; i++){
            str += ascAry[i]+",";
        }
        str.substring(0, str.length()-1);
        System.out.println("sort asc result : "+str);

        sortDesc(descAry);
        str = "";
        for (int i=0; i<descAry.length; i++){
            str += descAry[i]+",";
        }
        str.substring(0, str.length()-1);
        System.out.println("sort desc result :"+str);
    }

    /**
     * 升序排序
     * @param ary
     */
    public static void sortAsc(Integer[] ary){
        for (int i = 0; i < ary.length - 1; i++) {
            for (int j = 0; j < ary.length - i - 1; j++) {
                int temp = ary[j];
                if (ary[j] > ary[j + 1]) {
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排序
     * @param ary
     */
    public static void sortDesc(Integer[] ary){
        for(int i = 0; i< ary.length - 1; i++) {
            for(int j = 0;j< ary.length - i -1;j++) {
                if(ary[j] < ary[j+1]) {
                    int temp = ary[j];
                    ary[j] = ary[j+1];
                    ary[j+1] = temp;
                }
            }
        }
    }
}
