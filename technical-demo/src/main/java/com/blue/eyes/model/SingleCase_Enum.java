package com.blue.eyes.model;

/*** 
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-12 9:14
 *           '::::::::::::'           @description 单列模式——枚举
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
public class SingleCase_Enum {

    private SingleCase_Enum(){

    }

    public static SingleCase_Enum getSingleCase(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingleCase_Enum singleCase;

        Singleton(){
            singleCase = new SingleCase_Enum();
        }

        public SingleCase_Enum getInstance(){
            return singleCase;
        }
    }
}
