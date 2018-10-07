package com.gyq.jpa.service;

import com.gyq.jpa.entity.TReportEntity;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author gaoyaqiu
 * @date 2018/5/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportserviceTest {

    @Autowired
    private Reportservice reportservice;

    // @Test
    public void list() {
        System.out.println(reportservice.list());
    }

   // @Test
    public void add() throws Exception {

        long start = System.currentTimeMillis();
        BufferedReader reader = null;
        String file = "/Users/gaoyaqiu/Downloads/V5701702S0053_Detail_2018_4.csv";
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            String line = null;
            int i = 0;
            List<TReportEntity> list = newArrayList();
            while (!Strings.isNullOrEmpty(line = reader.readLine())) {
                // 首先去除无用的干扰的字符串
                // {"ImageType":"","ServiceType":"","VMName":"","VMProperties":"","UsageType":"DataTrOut"}
                // "StandardIO-BlockBlobWriteOperationUnits(in10,000s)"
               // System.out.println("第" + i + "行: 原始数据: " + line);
                String str = line.replaceAll("\\{.*}", "").replaceAll("\\(.*?\\)", "");
                String item[] = str.split(",");
               // System.out.println("替换之后的数据： " + str + " 数组长度: " + item.length);

                TReportEntity reportEntity = new TReportEntity();
                reportEntity.setAccountOwnerId(replaceStr(item[0]));
                reportEntity.setAccountName(replaceStr(item[1]));
                reportEntity.setServiceAdministratorId(replaceStr(item[2]));
                reportEntity.setSubscriptionId(replaceStr(item[3]));
                reportEntity.setSubscriptionGuid(replaceStr(item[4]));
                reportEntity.setSubscriptionName(replaceStr(item[5]));
                reportEntity.setReportDate(replaceStr(item[6]));
                reportEntity.setReportMonth(Integer.valueOf(replaceStr(item[7])));
                reportEntity.setReportDay(Integer.valueOf(replaceStr(item[8])));
                reportEntity.setReportYear(Integer.valueOf(replaceStr(item[9])));
                reportEntity.setProduct(replaceStr(item[10]));
                reportEntity.setMeterId(replaceStr(item[11]));
                reportEntity.setMeterCategory(replaceStr(item[12]));
                reportEntity.setMeterSubCategory(replaceStr(item[13]));
                reportEntity.setMeterRegion(replaceStr(item[14]));
                reportEntity.setMeterName(replaceStr(item[15]));
                reportEntity.setConsumedQuantity(new BigDecimal(replaceStr(item[16])));
                reportEntity.setResourceRate(new BigDecimal(replaceStr(item[17])));
                reportEntity.setExtendedCost(new BigDecimal(replaceStr(item[18])));
                reportEntity.setResourceLocation(replaceStr(item[19]));
                reportEntity.setConsumedService(replaceStr(item[20]));
                reportEntity.setInstanceId(replaceStr(item[21]));
                reportEntity.setServiceInfo1(replaceStr(item[22]));
                reportEntity.setServiceInfo2(replaceStr(item[23]));
                reportEntity.setAdditionalInfo(replaceStr(item[24]));
                reportEntity.setTags(replaceStr(item[25]));
                reportEntity.setStoreServiceIdentifier(replaceStr(item[26]));
                reportEntity.setDepartmentName(replaceStr(item[27]));
                reportEntity.setCostCenter(replaceStr(item[28]));
                reportEntity.setUnitOfMeasure(replaceStr(item[29]));
                reportEntity.setResourceGroup(replaceStr(item[30]));
                list.add(reportEntity);
                i++;
            }

            reportservice.saveInBatch(list);

            long end = System.currentTimeMillis();
            System.out.println("总数: " + i + " 耗时: " + (end - start) / 1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
    }

    private String replaceStr(String str) {
        return str.replaceAll("\"", "");
    }
}