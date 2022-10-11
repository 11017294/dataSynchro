package com.chen.datasynchro.service.impl;


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

    public void test(){
//        new Thread(() -> { testService.zhu(); }).start();
//        new Thread(() -> { testService.fu(); }).start();
        testService.fu();
        testService.zhu();
    }

}
