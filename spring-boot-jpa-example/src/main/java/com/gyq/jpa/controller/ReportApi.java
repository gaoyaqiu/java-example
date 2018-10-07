package com.gyq.jpa.controller;

import com.gyq.jpa.annoation.log.LogStyle;
import com.gyq.jpa.entity.TReportEntity;
import com.gyq.jpa.service.Reportservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaoyaqiu
 * @date 2018/10/7
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class ReportApi {

    @Autowired
    private Reportservice reportservice;

    @LogStyle(version = "1.0", beforeDesc = "查询数据开始", afterDesc = "查询数据结束: {}")
    @GetMapping("/list")
    public List<TReportEntity> findAll(){
        return reportservice.list();
    }
}


