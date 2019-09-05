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
public class CachedRunnable implements Runnable {

    public static Integer i = 0;
    @Override
    public void run() {
        System.out.println("start thread i:"+i);
        i ++;
        System.out.println("end  thread  i:"+i);
    }

    public static void main(String[] args) {
        //使用 CachedThreadPool 管理异步任务的执行，而无须显示地管理线程的生命周期
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0; i<100; i++){
            service.execute(new CachedRunnable());
        }
        //防止新任务提交给 ExecutorService ，这个线程在 Executor 中所有任务完成后退出
        service.shutdown();
        System.out.println("service shutdown");
    }
}
