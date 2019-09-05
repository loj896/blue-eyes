package com.blue.eyes.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class FixedRunnable implements Runnable {

    public static Integer i = 0;
    @Override
    public void run() {
        System.out.println("start thread i:"+i);
        i ++;
        System.out.println("end  thread  i:"+i);
    }

    public static void main(String[] args) {
        //使用 FixedThreadPool 限制线程的数量
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i=0; i<100; i++){
            service.execute(new FixedRunnable());
        }
        service.shutdown();
        System.out.println("service shutdown");
    }
}
