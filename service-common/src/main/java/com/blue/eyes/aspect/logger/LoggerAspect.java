package com.blue.eyes.aspect.logger;

import com.alibaba.fastjson.JSON;
import com.blue.eyes.dto.logger.LoggerDto;
import com.blue.eyes.model.Constant;
import com.blue.eyes.service.logger.LoggerService;
import com.blue.eyes.util.HttpContextUtil;
import com.blue.eyes.util.IpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-05-29 15:14
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
@Configuration
@Aspect
public class LoggerAspect {

    @Resource
    private LoggerService loggerService;

    @Pointcut("@annotation(com.blue.eyes.aspect.logger.SysLogger)")
    public void pointcut() {    }

    @Around(value = "pointcut()")
    public Object addLog(ProceedingJoinPoint joinPoint) throws Exception{
        Object result;
        LoggerDto loggerDto = new LoggerDto();
        Object[] args = null;
        Object proceed = null;
        long startTime = 0;
        try {
            result = joinPoint.proceed();
            //请求参数
            args = joinPoint.getArgs();
            //返回结果
            proceed = joinPoint.proceed();

            Signature sig = joinPoint.getSignature();
            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) sig;
            Object target = joinPoint.getTarget();

            String className = target.getClass().getName();
            Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());;

            String handlerInfo = className + "#" + method.getName();

            SysLogger sysLogger = AnnotationUtils.findAnnotation(method, SysLogger.class);

            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();

            loggerDto.setReqURL(request.getRequestURI());
            loggerDto.setIp(IpUtil.getIpAddr(request));
            loggerDto.setUserId("000");
            loggerDto.setUserName("loj");
            loggerDto.setDesc(sysLogger.desc());
            loggerDto.setLoggerType(sysLogger.type());
            loggerDto.setMethod(handlerInfo);
            loggerDto.setReqTime(new Date());
            loggerDto.setParams(JSON.toJSONString(args));

            startTime = System.currentTimeMillis();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            loggerDto.setRestCode(Constant.RESCODE_EXCEPTION);
            String throwableMessage = throwable.getMessage();
            loggerDto.setMsg(throwableMessage);
            throw new Exception(throwable);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            loggerDto.setDuration(duration);
            loggerDto.setRest(JSON.toJSONString(proceed));
            loggerService.addMgLogger(loggerDto);
        }
        return result;
    }


}
