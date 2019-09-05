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
public class ThreadRunnable implements Runnable {

    public static Integer i = 0;
    @Override
    public void run() {
        System.out.println("start thread i:"+i);
        i ++;
        System.out.println("end  thread  i:"+i);
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++){
            //使用 Thread 类托管 程序不会等到 run 方法执行完毕就会执行下面的指令
            Thread thread = new Thread(new ThreadRunnable());
            thread.start();
        }
        System.out.println("Waiting thread ...");
    }
}
