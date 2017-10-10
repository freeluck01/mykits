/*
 * Powered By caoxm
 * Since 2016 - 2016
 */

package com.mykits.service.impl;

import com.mykits.client.vo.DemoVo;
import com.mykits.dao.DemoDao;
import com.mykits.domain.Demo;
import com.mykits.service.DemoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author caoxm
 * @version 1.0
 * @since 1.0
 */

@Service(value="demoService")
public class DemoServiceImpl implements DemoService {

    private Logger log = LogManager.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoDao demoDao;

    /**
     *
     * @see com.mykits.client.service.DemoService
     */
    @Transactional(rollbackFor = {RuntimeException.class,Throwable.class}, propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ)
    @Override
    public int save(Demo demo) {
        log.info("保存Demo信息");
//        Demo demo = voToDomain(demoVo);
        int cunt = demoDao.insert(demo);
        return cunt;
    }

    private Demo voToDomain(DemoVo demoVo) {
        Demo model = new Demo();
        model.setId(demoVo.getId());
        model.setName(demoVo.getName());
        model.setErp(demoVo.getErp());
        model.setPhone(demoVo.getPhone());
        model.setEmail(demoVo.getEmail());
        model.setOrgid(demoVo.getOrgid());
        model.setDepart(demoVo.getDepart());

        return model;
    }
}
