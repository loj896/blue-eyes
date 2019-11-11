package com.blue.eyes.service.impl;

import com.blue.eyes.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-11 16:01
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
@Service
public class TestServiceImpl implements TestService {

    @Resource
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorDefault")
    @Override
    public String hystrixtError(String name) throws Exception {
        if(1>0){
            throw new Exception();
        }
        return "hi,"+name+", this is hystrixtError method.";
    }

    @HystrixCommand(fallbackMethod = "errorDefault")
    @Override
    public String hystrixNormal(String name) throws Exception {
        return "hi,"+name+", this is hystrixNormal method.";
    }

    @Override
    public String errorDefault(String name) {
        return "hi,"+name+", this is errorDefault method.";
    }
}
