package com.mykits.controller;

import com.mykits.controller.base.BaseController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caoxingming on 2016/5/23.
 */
@Controller
public class IndexController extends BaseController{
    private static Logger log = LogManager.getLogger(IndexController.class);

    /**
     * 跳转至新增页面
     * @return
     */
    @RequestMapping("/")
    public String toIndexPage(){
        log.info("打开首页");
        return "/index1.html";
    }

}
