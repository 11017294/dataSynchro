package com.chen.datasynchro.service.impl;

import com.chen.datasynchro.entity.master.MasterWebVisit;
import com.chen.datasynchro.entity.slave.SlaveWebVisit;
import com.chen.datasynchro.mapper.master.MasterWebVisitMapper;
import com.chen.datasynchro.mapper.slave.SlaveWebVisitMapper;
import com.chen.datasynchro.service.WebVisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<MasterWebVisit> masterWebVisitList = masterWebVisitList();
        List<SlaveWebVisit> slaveWebVisitList = slaveWebVisitList();

        System.out.println("masterWebVisitList:" + masterWebVisitList.size());
        System.out.println("slaveWebVisitList:" + slaveWebVisitList.size());

//        List<SlaveWebVisit> slaveWebVisits = BeanUtil.copyToList(masterWebVisitList, SlaveWebVisit.class);
//        for (SlaveWebVisit slaveWebVisit : slaveWebVisits) {
//            slaveWebVisit.insert();
//        }
    }

    @Transactional
    public List<MasterWebVisit> masterWebVisitList(){
        return masterWebVisitMapper.selectList(null);
    }

    public List<SlaveWebVisit> slaveWebVisitList(){
        return slaveWebVisitMapper.selectList(null);
    }
}
