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
public class SingleRunnable implements Runnable {

    public static Integer i = 0;
    @Override
    public void run() {
        System.out.println("start thread i:"+i);
        i ++;
        System.out.println("end  thread  i:"+i);
    }

    public static void main(String[] args) {
        //使用 SingleThreadExecutor 有序 就是线程数量为 1 的 FixedThreadPool，只有唯一一个任务在运行
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i=0; i<100; i++){
            service.execute(new SingleRunnable());
        }
        service.shutdown();
        System.out.println("service shutdown");
    }
}
