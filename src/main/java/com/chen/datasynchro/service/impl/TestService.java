package com.chen.datasynchro.service.impl;

import com.chen.datasynchro.dataSource.DataSourceConstants;
import com.chen.datasynchro.dataSource.annotion.DataSource;
import com.chen.datasynchro.entity.WebVisit;
import com.chen.datasynchro.mapper.WebVisitMapper;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @DataSource
    public void zhu(){
        System.out.println("zhu");
        List<WebVisit> list = query();
        int size = list.size();
        System.out.println("zhu:" + size);
        insert(list.get(0));
    }

    @SneakyThrows
    @DataSource(DataSourceConstants.DS_KEY_SLAVE)
    public void fu(){
        System.out.println("fu");
        List<WebVisit> list = query();
        int size = list.size();
        System.out.println("fu:" + size);
        insert(list.get(0));
    }

    private List<WebVisit> query(){
        return webVisitMapper.selectList(null);
    }

    public void insert(WebVisit webVisit){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        webVisit.setId(id.substring(0, 32));
        webVisit.setCreateTime(new Date());
        webVisit.setUpdateTime(new Date());
//        webVisit.insert();
    }
}
