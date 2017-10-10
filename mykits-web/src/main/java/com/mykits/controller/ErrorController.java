package com.mykits.controller;

import com.mykits.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by caoxingming on 2017/3/2
 */
@Controller
public class ErrorController extends BaseController {

    @RequestMapping(method= RequestMethod.GET,value="/404")
    public String notFind(Model view){
        System.out.println("发生异常");
        return "/error/404";
    }
}
