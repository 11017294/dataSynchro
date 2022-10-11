package com.chen.datasynchro.controller;

import com.chen.datasynchro.service.WebVisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Web访问记录表 前端控制器
 * </p>
 *
 * @author MaybeBin
 * @since 2022-08-26
 */
@RestController
@RequestMapping
@Api(value = "测试", tags = {"多数据源交互测试"})
public class WebVisitController {

    @Autowired
    private WebVisitService webVisitService;

    @GetMapping("/getList")
    @ApiOperation(value = "测试", notes = "多数据源交互测试")
    public void getList(){
        webVisitService.test();
    }

}

