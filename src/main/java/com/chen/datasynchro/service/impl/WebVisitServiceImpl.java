package com.chen.datasynchro.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.datasynchro.dataSource.DataSourceConstants;
import com.chen.datasynchro.dataSource.DynamicDataSourceContextHolder;
import com.chen.datasynchro.entity.WebVisit;
import com.chen.datasynchro.mapper.WebVisitMapper;
import com.chen.datasynchro.service.WebVisitService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author：MaybeBin
 * @Date: 2022-10-10 15-43
 */
@Service
public class WebVisitServiceImpl implements WebVisitService {

    @Resource
    private WebVisitMapper webVisitMapper;

    public void test(){
        new Thread(() -> zhu()).start();
        new Thread(() -> fu()).start();

        // 默认master查询
        List<WebVisit> resultDataMaster = webVisitMapper.selectList(new QueryWrapper<>());

        // 切换数据源，在slave查询
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        List<WebVisit> resultDataSlave = webVisitMapper.selectList(null);
        System.out.println("resultDataMaster：" + resultDataMaster.size());
        System.out.println("resultDataSlave：" + resultDataSlave.size());
        // 恢复数据源
        DynamicDataSourceContextHolder.removeContextKey();
    }

    @SneakyThrows
    private void zhu(){
        System.out.println("zhu");
        Thread.sleep(1000);
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_MASTER);
        List<WebVisit> list = query();
        int size = list.size();
        Thread.sleep(2000);
        System.out.println("zhu:" + size);
    }

    @SneakyThrows
    private void fu(){
        System.out.println("fu");
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        Thread.sleep(2000);
        List<WebVisit> list = query();
        int size = list.size();
        System.out.println("fu:" + size);
    }

    private List<WebVisit> query(){
        return webVisitMapper.selectList(null);
    }
}
