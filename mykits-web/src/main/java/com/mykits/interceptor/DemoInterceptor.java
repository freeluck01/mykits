package com.mykits.interceptor;

import com.mykits.domain.Demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by caoxingming on 2017/3/8
 */
@Component
@Aspect
public class DemoInterceptor {
    private static final Logger logger = LogManager.getLogger(DemoInterceptor.class);
//    @Pointcut("execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.save*(..)) || execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.update*(..)) ||execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.delete(..))" +
//            "||execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.batchSave(..))")
//    public void addMethod() {
//
//    }

    /**
     * 定义com.mykits.service包及子包下save(Demo demo)方法切入点savePointcut。此处不需实现方法体
     */
    @Pointcut(value="execution(* com.mykits.service..*.save*(..)) && args(demo)", argNames = "demo")
    public void savePointcut(Demo demo) {}

    /**
     * 定义savePointcut切入点的前置通知
     * @param demo
     */
    @Before(value = "savePointcut(demo)", argNames = "demo")
    public void beforeAdvice(Demo demo) {
        logger.info(">>>将要保存demo:" + demo.toString());
    }

    /**
     * 定义savePointcut切入点的后置通知
     * @param demo
     */
    @After(value = "savePointcut(demo)", argNames = "demo")
    public void afterAdvice(Demo demo) {
        logger.info(">>>已经完成保存demo:" + demo.toString());
    }
}
