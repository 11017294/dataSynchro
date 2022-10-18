package com.chen.datasynchro.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.datasynchro.entity.WebVisit;
import com.chen.datasynchro.mapper.WebVisitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author：MaybeBin
 * @Date: 2022-10-11 16-09
 */
@Service
public class TestService {

    @Resource
    private WebVisitMapper webVisitMapper;

    @DS("localOracle")
    public void zhu(){
        System.out.println("zhu");
        List<WebVisit> list = query();
        insert(list.get(0));
        int i = 1 / 0;

    }

    @DS("remoteOracle")
    public void fu(){
        System.out.println("fu");
        List<WebVisit> list = query();
        insert(list.get(0));
        int i = 1 / 0;
    }

    private List<WebVisit> query(){
        Page<WebVisit> page = new Page<>();
        page.setSize(5);
        page.setCurrent(1);
        return webVisitMapper.selectPage(page,null).getRecords();
    }

    public void insert(WebVisit webVisit){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        webVisit.setId(id.substring(0, 32));
        webVisit.setCreateTime(new Date());
        webVisit.setUpdateTime(new Date());
        webVisit.insert();
    }
}
