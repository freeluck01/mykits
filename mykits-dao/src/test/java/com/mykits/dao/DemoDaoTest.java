/*
 * Powered By caoxm
 * Since 2016 - 2016
 */

package com.mykits.dao;

/**
 * @author caoxm
 * @version 1.0
 * @since 1.0
 */

import com.mykits.dao.base.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mykits.dao.base.BaseIbatis3Example;

import com.mykits.domain.*;
import com.mykits.dao.criteria.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application*.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoDaoTest {

    static long ID;

    static long FIND_BY_KEY = new Date().getTime();

    @Autowired
    private DemoDao dao;
    
    @Test
    public void test1_insert(){
    	Demo model = new Demo();
    	model.setId(1l);
    	model.setName("Name");
    	model.setErp("Erp");
    	model.setPhone("Phone");
    	model.setEmail("Email");
    	model.setOrgid("Orgid");
    	model.setDepart("Depart");
        int count = dao.insert(model);
		ID=count;
        Assert.assertTrue(count > 0);
    }

    @Test
    public void test2_update() {
    	Demo model = new Demo();

    	model.setId(1l);
    	model.setName("Name");
    	model.setErp("Erp");
    	model.setPhone("Phone");
    	model.setEmail("Email");
    	model.setOrgid("Orgid");
    	model.setDepart("Depart");
		

    	model.setId(null);
		
        int i = dao.updateByPK(model);
        Assert.assertEquals(0, i);
        
    	model.setId(ID);
        i = dao.updateByPK(model);
        Assert.assertEquals(1, i);
    }

    @Test
    public void test3_getById() {
    	Demo model =  dao.getByPK(ID);
        Assert.assertNotNull(model);
    }
    
    @Test
    public void test4_findByKey(){
		// TODO
		BaseIbatis3Example example = new BaseIbatis3Example();
		DemoCriteria model = example.createCriteria(DemoCriteria.class);
//		model.andXX(FIND_BY_KEY);
		List<Demo> list = dao.findByExample(example);
		Assert.assertNotNull(list);
//		Assert.assertEquals(FIND_BY_PAYNO, list.get(0).getXX());
	}
    
    @Test
    public void test5_delete() {
    	int count = dao.deleteByPK(ID);
        Assert.assertEquals(1, count);
    }
}
