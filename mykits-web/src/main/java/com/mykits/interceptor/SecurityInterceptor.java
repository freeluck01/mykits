package com.mykits.interceptor;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Mvc安全拦截器
 */
public class SecurityInterceptor implements HandlerInterceptor {
	Logger logger = LogManager.getLogger(SecurityInterceptor.class);
    
    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUri = request.getRequestURI();
        //排除的url
        for (String url : excludedUrls) {
            if (requestUri.matches(url)) {
                return true;
            }
        }
//        if (request.getHeader("x-requested-with") != null
//                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
//            //ajax请求返回个消息给前台
//            PrintWriter printWriter = response.getWriter();
//            printWriter.print("sessionfail");
//            printWriter.flush();
//            printWriter.close();
//        } else {
//            response.sendRedirect("/index.html");
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
