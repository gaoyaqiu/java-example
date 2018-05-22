package com.gyq.jpa.repository;

import com.gyq.jpa.entity.TReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaoyaqiu
 * @date 2018/5/21
 */
public interface ReportRepository extends JpaRepository<TReportEntity, Long>{
}
