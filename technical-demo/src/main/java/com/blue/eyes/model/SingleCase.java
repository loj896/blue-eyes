package com.blue.eyes.model;

/*** 
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-12 9:14
 *           '::::::::::::'           @description 单列模式——懒汉+双重验证
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
public class SingleCase {

    private SingleCase(){

    }

    // 使用 volatile 禁止指令重排
    private volatile static SingleCase singleCase = null;

    public static SingleCase getSingleCase(){
        if(null == singleCase){
            synchronized (SingleCase.class){
                if(null == singleCase){
                    singleCase = new SingleCase();
                }
            }
        }
        return singleCase;
    }

}
