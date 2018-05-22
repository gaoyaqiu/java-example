package com.gyq.service.excel;

import com.gyq.utils.excel.JxlExcelHandle;
import jxl.Cell;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工excel操作.
 *
 * @auther gaoyaqiu
 */
public class ExampleExcelHandleService extends JxlExcelHandle {

    @Override
    protected boolean checkData(Cell[] cells, String[] excelColNames, Map<String, String> map) {
       // Map<String, String> colLenMap = getColumnLenMap();
        for (int j = 0; j < cells.length; j++) {
            String content = cells[j].getContents();
            String colname = excelColNames[j];

            map.put(colname, content);
        }

        return true;
    }

    @Override
    protected boolean upload(Map<String, String> map) {

        return true;
    }

    @Override
    protected Map<String, String> getColumnLenMap() {

        Map<String, String> map = new HashMap<>();
     /*   String[] columnNames = new String[]{"staffName", "post", "mobile", "companyCode", "airportCode", "professionKey", "positionKey"};
        String[] columnLengths = new String[]{"20", "20", "20", "32", "32", "32", "400"};

        for (int i = 0; i < columnNames.length; i++) {
            map.put(columnNames[i], columnLengths[i]);
        }*/
        return map;
    }

    @Override
    protected boolean checkDataLength(String content, String colname, Map<String, String> map) {
        try {
            String lenStr = map.get(colname);
            Integer len = Integer.valueOf(lenStr);
            if (content.length() > len.intValue()) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
