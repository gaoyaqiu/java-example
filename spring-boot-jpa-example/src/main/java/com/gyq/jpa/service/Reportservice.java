package com.gyq.jpa.service;

import com.gyq.jpa.entity.TReportEntity;
import com.gyq.jpa.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gaoyaqiu
 * @date 2018/5/21
 */
@Service
public class Reportservice {

    @Autowired
    private ReportRepository reportRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(TReportEntity reportEntity) {
        reportRepository.save(reportEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveInBatch(List<TReportEntity> list) {
        reportRepository.save(list);
    }

}
