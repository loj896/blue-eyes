package com.blue.eyes.generic;

import org.apache.poi.ss.formula.functions.T;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-10-10 11:23
 *           '::::::::::::'           @description 泛型方法
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
public class GenericMethod {

    public static <T> void printArray(T [] inputArray){
        for (T t : inputArray){
            System.out.printf("%s", t);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Integer 类型
        Integer [] intArray = new Integer[]{3,4,1,5,6};
        System.out.println( "整型数组元素为:" );
        printArray(intArray);

        String [] strArray = new String[]{"hh","heqs","jj"};

        System.out.println( "字符串数组元素为:" );
        printArray(strArray);
    }
}
