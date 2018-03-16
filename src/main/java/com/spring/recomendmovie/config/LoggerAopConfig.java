package com.spring.recomendmovie.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAopConfig {

    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.spring.recomendmovie..*.* (..))")
    public void webLog() {}

//    @Before("execution(* *(..))")
    @Before("webLog()")
    public void invokeBefore(JoinPoint point) {
        String realClassName = getRealClassName(point);
        logger.info("调用-----"+ realClassName + " 执行 " + getMethodName(point) + " 方法之前");
    }

    @After("webLog()")
    public void invokeAfter(JoinPoint point) {
        String realClassName = getRealClassName(point);
        logger.debug("调用-----"+ realClassName + " 执行 " + getMethodName(point) + " 方法之后");
    }


    /**
     * 获取被代理对象的真实类全名
     * @param point 连接点对象
     * @return 类全名
     */
    private String getRealClassName(JoinPoint point) {
        return point.getTarget().getClass().getName();
    }

    /**
     * 获取代理执行的方法名
     * @param point 连接点对象
     * @return 调用方法名
     */
    private String getMethodName(JoinPoint point) {
        return point.getSignature().getName();
    }
}
