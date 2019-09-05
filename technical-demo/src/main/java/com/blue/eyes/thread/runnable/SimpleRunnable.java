package com.blue.eyes.thread.runnable;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-05 16:49
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
public class SimpleRunnable implements Runnable {

    public static Integer i = 0;
    @Override
    public void run() {
        System.out.println("start thread i:"+i);
        i ++;
        System.out.println("end  thread  i:"+i);
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            SimpleRunnable thread = new SimpleRunnable();
            thread.run();
        }
        System.out.println("Waiting thread ...");
    }
}
