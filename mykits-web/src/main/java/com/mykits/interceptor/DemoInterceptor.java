package com.mykits.interceptor;

import com.mykits.client.vo.DemoVo;
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
//    @Pointcut("execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.save*(..)) || execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.update*(..)) ||execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.delete(..))" +
//            "||execution(* com.jd.jos.market.dao.yuntu.impl.ImageDao*.batchSave(..))")
//    public void addMethod() {
//
//    }

    /**
     * 不需实现方法体
     */
    @Pointcut(value="execution(* com.mykits.service..*.save*(..)) && args(demoVo)", argNames = "demoVo")
    public void beforePointcut(DemoVo demoVo) {}

    /**
     * 定义通知：（前置通知）
     * @param demoVo
     */
    @Before(value = "beforePointcut(demoVo)", argNames = "demoVo")
    public void beforeAdvice(DemoVo demoVo) {
        System.out.println(">>>before advice param:" + demoVo.toString());
    }

    /**
     * 定义通知：（前置通知）
     * @param demoVo
     */
    //@After(value = "beforePointcut(demoVo)", argNames = "demoVo")
    public void afterAdvice(DemoVo demoVo) {
        System.out.println(">>>after advice param:" + demoVo.toString());
    }
}
