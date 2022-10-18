package com.chen.datasynchro.service.impl;


import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.chen.datasynchro.service.WebVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TestService testService;

    @DSTransactional
    public void test(){
        testService.zhu();
        testService.fu();
    }

}
