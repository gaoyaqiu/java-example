package com.gyq.utils.excel;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Excel工具接口类
 *
 * @auther gaoyaqiu
 */
public interface ExcelUtil {

    /**
     * 读取excel.
     *
     * @param filePath 文件路径
     * @param sheetNo  工作表编号 默认0
     * @param hasTitle 是否带有标题
     * @return 返回转换后的数据列表
     * @throws Exception
     */
    Object readExcel(String filePath, int sheetNo, boolean hasTitle) throws Exception;

    /**
     * 写入数据到指定excel文件中.
     *
     * @param data   数据列表
     * @param titles 标题列表
     * @param filePath 文件路径
     * @throws Exception
     */
    void writeExcel(List<Map<String, String>> data, String[] titles, String filePath) throws Exception;

    /**
     * 流读取Excel.
     *
     * @param is
     * @param sheetNo
     * @param hasTitle
     * @return
     * @throws Exception
     */
    Object readExcel(InputStream is, int sheetNo, boolean hasTitle) throws Exception;
}
