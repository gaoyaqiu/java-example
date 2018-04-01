package com.gyq.utils.excel;


import com.gyq.constant.MessageConstant;
import com.gyq.model.JsonResultWrapper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

/**
 * jxl操作 excel基础类.
 *
 * @auther gaoyaqiu
 */
@Slf4j
public abstract class JxlExcelHandle implements ExcelUtil {

    // 控制一次操作excel的总数据量大小
    public static final int LENG = 2;

    @Override
    public Object readExcel(String filePath, int sheetNo, boolean hasTitle) throws Exception {
        File file = new File(filePath);
        // 获取excel工作簿
        Workbook workbook = Workbook.getWorkbook(file);

        return getExcelData(sheetNo, hasTitle, workbook);
    }

    private Object getExcelData(int sheetNo, boolean hasTitle, Workbook workbook) {
        JsonResultWrapper<Object> data = null;
        List<Map<String, String>> result = newArrayList();

        StringBuffer sb = new StringBuffer(100);
        String excelColNames[] = null;

        Map<String, Object> errMap = new HashMap<>();
        // 如果有标题则从第1行开始(索引为0)
        int start = hasTitle ? 0 : 1;

        try {
            Sheet sheet = workbook.getSheet(sheetNo);
            Cell firstRow[] = sheet.getRow(start);

            if (firstRow != null) {
                // 保存excel中的列名称,用于校验列和单元格中的数据格式是否相符
                for (int i = 0; i < firstRow.length; i++) {
                    if (firstRow[i] != null && firstRow[i].getContents().trim().length() > 0) {
                        sb.append(firstRow[i].getContents()).append(",");
                    }
                }
                // 存储列名称
                excelColNames = sb.substring(0, sb.length() - 1).split(",");

                // 开始读取数据
                for (start += 1; start < sheet.getRows(); start++) {
                    Cell cells[] = sheet.getRow(start);
                    Map<String, String> staffMap = new LinkedHashMap<>();
                    // 校验数据格式
                    boolean ret = checkData(cells, excelColNames, staffMap);
                    if (!ret) {
                        errMap.put("errorRow", Integer.valueOf(start + 1));
                        errMap.put("successNum", Integer.valueOf(start - 2));
                        errMap.put("type", "dataValidity"); // 数据有效性错误
                        errMap.put("message", ret);
                        data = new JsonResultWrapper<>(MessageConstant.ERR_READ_EXCEL, errMap);
                        return data;
                    } else {
                        result.add(staffMap);

                        /*ret = upload(staffMap);
                        if (!"true".equals(ret)) {
                            errMap.put("errorRow", Integer.valueOf(start + 1));
                            errMap.put("successNum", Integer.valueOf(start - 2));
                            errMap.put("type", "db"); // db校验错误
                            errMap.put("message", ret);
                            data = new JsonResultWrapper<>(MessageConstant.ERR_READ_EXCEL, errMap);
                            log.error("jxl读取excel异常:{}", JsonUtil.object2Json(data));
                            return data;
                        }*/
                    }
                }
            } else {
                errMap.put("errorRow", Integer.valueOf(start + 1));
                errMap.put("successNum", Integer.valueOf(start - 2));
                errMap.put("type", "template"); // 数据有效性错误
                errMap.put("message", "不能破坏模板内容,必须留有表的列名字段");
                data = new JsonResultWrapper<>(MessageConstant.ERR_READ_EXCEL_TEMPLATE, errMap);
                return data;
            }

        } catch (Exception e) {
            errMap.put("errorRow", Integer.valueOf(start + 1));
            errMap.put("successNum", Integer.valueOf(start - 2));
            errMap.put("type", "system"); // 数据有效性错误
            errMap.put("message", "jxl读取excel异常");
            data = new JsonResultWrapper<>(MessageConstant.ERR_READ_EXCEL, errMap);
            log.error("jxl读取excel异常", e);
            return data;
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }

       /* errMap.put("successNum", Integer.valueOf(start - 2));
        data = new JsonResultWrapper<>(MessageConstant.SUCCESS, errMap);
        return data;*/

        return result;
    }

    @Override
    public Object readExcel(InputStream is, int sheetNo, boolean hasTitle) throws Exception {
        // 获取excel工作簿
        Workbook workbook = Workbook.getWorkbook(is);

        return getExcelData(sheetNo, hasTitle, workbook);
    }

    /**
     * 写入excel.
     *
     * @param data   数据列表
     * @param titles 标题列表
     * @throws Exception
     */
    @Override
    public void writeExcel(List<Map<String, String>> data, String[] titles, String filePath) throws Exception {
        WritableWorkbook workbook = null;
        try {
            workbook = Workbook.createWorkbook(new File(filePath));
            WritableSheet wsheet = workbook.createSheet("test", 0);

            // 设置表头
            if (null != titles && titles.length > 0) {
                for (int j = 0; j < titles.length; j++) {
                    Label label = new Label(j, 0, titles[j]);
                    wsheet.addCell(label);
                }
            }

            if (null != data && data.size() > 0) {
                int j = 0;
                for (int i = 0; i < data.size(); i++) {
                    Map<String, String> map = data.get(i);
                    for (Map.Entry entry : map.entrySet()) {
                        //第一个参数是列索引 第二个参数是行索引 将定义好的单元格添加到工作表中
                        wsheet.addCell(new Label(j, i, (String) entry.getValue()));
                        j++;
                    }
                    j = 0;
                }
            }

            // TODO: 2018/4/1 当一个sheet达到5W数据，需要分sheet存储
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.write();
                workbook.close();
            }
        }
    }


    /**
     * 校验数据有效性及类型转换(由子类实现).
     *
     * @param cells         单元格内容
     * @param excelColNames 字段名称
     * @param staffMap      结果集("字段":“单元格内容”)
     * @return
     */
    protected abstract boolean checkData(Cell cells[], String excelColNames[], Map<String, String> staffMap);


    /**
     * 提交服务端(由子类实现).
     *
     * @param map excel中所有数据
     * @return
     */
    protected abstract boolean upload(Map<String, String> map);


    /**
     * 存储字段长度映射关系(由子类实现).
     *
     * @return
     */
    protected abstract Map<String, String> getColumnLenMap();


    /**
     * 校验内容和列字段值限制的长度是否相符(由子类实现).
     *
     * @param content
     * @param colname
     * @param map
     * @return
     */
    protected abstract boolean checkDataLength(String content, String colname, Map<String, String> map);

}
