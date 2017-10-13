package com.mykits.controller;

import com.mykits.controller.base.BaseController;
import com.mykits.domain.Demo;
import com.mykits.service.DemoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by caoxingming on 2016/5/23.
 */
@Controller
public class DemoController extends BaseController{
    private static Logger log = LogManager.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    /**
     * 调整至新增页面
     * @return
     */
    @RequestMapping("/demo/create")
    public String create(){
        return "/demo_create";
    }

    /**
     * 保存表单数据
     * @return
     */
    @RequestMapping(value="/demo/save", method = RequestMethod.POST)
    public String save(Model model, Demo demo)throws Exception{
        try {
            int count = demoService.save(demo);
            model.addAttribute("count",count);
        } catch (Exception e) {
            log.info("保存DemoVo失败，失败信息："+e.getMessage());
            throw e;
        }

        return "/demo_success";
    }

    /**
     * 跳转至表单展示页面
     * @return
     */
    @RequestMapping(value="/demo/success")
    public String show(){
        return "/demo_success";
    }
}
