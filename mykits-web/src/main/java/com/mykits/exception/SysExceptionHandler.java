package com.mykits.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by caoxingming on 2017/3/9
 */
//@Component 考虑到易读性，不适用Component注解，已改为在spring-mvc.xml中配置
public class SysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ex", ex);

        // 根据不同错误转向不同页面
        if(ex instanceof BusinessException) {
            return new ModelAndView("error-business", model);
        } else {
            System.out.println("123456789");
            return new ModelAndView("/error/404", model);
        }
    }
}
