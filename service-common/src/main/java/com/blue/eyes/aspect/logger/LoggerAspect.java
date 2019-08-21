package com.blue.eyes.aspect.logger;

import com.blue.eyes.dto.logger.LoggerDto;
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
        long startTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
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

            /*System.out.println("desc:"+sysLogger.desc()+",type:"+sysLogger.type()+",duration："+duration+",className:"+className);
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i].getClass().getTypeName());
                System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
            }*/

            HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
            LoggerDto loggerDto = new LoggerDto();
            loggerDto.setReqURL(request.getRequestURI());
            loggerDto.setIp(IpUtil.getIpAddr(request));
            loggerDto.setUserId("000");
            loggerDto.setUserName("loj");
            loggerDto.setDesc(sysLogger.desc());
            loggerDto.setLoggerType(sysLogger.type());
            loggerDto.setMethod(handlerInfo);
            loggerDto.setReqTime(new Date());

            loggerService.addMgLogger(loggerDto);
        }
        return result;
    }
}
