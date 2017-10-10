/*
 * Powered By caoxm
 * Since 2016 - 2016
 */

package com.mykits.service;

import com.mykits.client.service.DemoService;
import com.mykits.client.vo.DemoVo;
import com.mykits.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by caoxingming on 2016/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application*.xml")
public class DemoServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void testSave(){
        DemoVo vo = new DemoVo();
        vo.setName("Name");
        vo.setErp("Erp");
        vo.setPhone("Phone");
        vo.setEmail("Email");
        vo.setOrgid("Orgid");
        vo.setDepart("Depart");
        int count = demoService.save(vo);
        Assert.assertTrue(count > 0);

    }
}
