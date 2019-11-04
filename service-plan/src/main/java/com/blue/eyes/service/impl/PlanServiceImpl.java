package com.blue.eyes.service.impl;

import com.blue.eyes.dto.SelMSDto;
import com.blue.eyes.service.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-04 12:31
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
public class PlanServiceImpl implements PlanService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public boolean addPlan(SelMSDto msDto) {
        URI uri = restTemplate.postForLocation("http://47.105.161.199/service-mail/mail/getMailSendList", msDto);
        return false;
    }
}
