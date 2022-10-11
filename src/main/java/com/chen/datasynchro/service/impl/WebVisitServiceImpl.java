package com.chen.datasynchro.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.datasynchro.entity.master.MasterWebVisit;
import com.chen.datasynchro.entity.slave.SlaveWebVisit;
import com.chen.datasynchro.mapper.master.MasterWebVisitMapper;
import com.chen.datasynchro.mapper.slave.SlaveWebVisitMapper;
import com.chen.datasynchro.service.WebVisitService;
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
    private MasterWebVisitMapper masterWebVisitMapper;
    @Resource
    private SlaveWebVisitMapper slaveWebVisitMapper;

    public void test(){
        List<MasterWebVisit> masterWebVisit = masterWebVisitMapper.selectList(new QueryWrapper<>());
        List<SlaveWebVisit> slaveWebVisits = BeanUtil.copyToList(masterWebVisit, SlaveWebVisit.class);

        for (SlaveWebVisit slaveWebVisit : slaveWebVisits) {
            slaveWebVisit.insert();
        }
    }
}
