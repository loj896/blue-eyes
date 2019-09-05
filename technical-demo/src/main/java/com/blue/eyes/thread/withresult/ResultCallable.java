package com.blue.eyes.thread.withresult;

import java.util.ArrayList;
import java.util.concurrent.*;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-09-05 20:39
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
public class ResultCallable implements Callable<String> {

    private int id;

    public ResultCallable(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result is "+id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futrues = new ArrayList<>();
        for (int i=0; i<100; i++){
            futrues.add(service.submit(new ResultCallable(i)));
        }
        System.out.println("start print out ********************");
        for (Future<String> fs : futrues){
            System.out.println(fs.get());
        }
        System.out.println("end  print  out ********************");
    }
}
