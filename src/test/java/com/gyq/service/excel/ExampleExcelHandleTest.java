package com.gyq.service.excel;

import com.google.common.base.Strings;
import com.gyq.utils.excel.JxlExcelHandle;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newLinkedHashMap;

/**
 * @auther gaoyaqiu
 * @date 2018/4/1
 */
public class ExampleExcelHandleTest {


    @Test
    public void importTest() {

        String file = "/Users/gaoyaqiu/Downloads/gc.xls";
        try {
            JxlExcelHandle jxlExcelHandle = new ExampleExcelHandleService();
            List<Map<String, String>> data = (List<Map<String, String>>) jxlExcelHandle.readExcel(file, 0, true);

            List<Map<String, String>> newData = newArrayList();
              for (int i = 0; i < data.size(); i++) {
//            for (int i = 0; i < 1; i++) {
                resolveData(data.get(i), newData);
            }

            jxlExcelHandle.writeExcel(newData, null, "/Users/gaoyaqiu/Downloads/gc3.xls");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resolveData(Map<String, String> map, List<Map<String, String>> newData) throws Exception {

        String s1 = map.get("经销商编号");
        String s2 = map.get("经销商").replaceAll("\"", "");
        String s3 = map.get("行业").replaceAll("\"", "");
        String s4 = map.get("主要设别类型").replaceAll("\"", "");
        String s5 = map.get("整体用油量");
        String s6 = map.get("客户名称").replaceAll("\"", "");
        String s7 = map.get("设备编号").replaceAll("\"", "");
        String s8 = map.get("设备类型").replaceAll("\"", "");
        // 如果有值需要拆分
        String s9 = map.get("用油点名称");
        if (!Strings.isNullOrEmpty(s9)) {
            s9 = s9.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            String[] sp9 = s9.split(",");

            String s10 = map.get("别名");
            s10 = s10.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            String[] sp10 = s10.split(",");

            String s11 = map.get("油量");
            s11 = s11.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            String[] sp11 = s11.split(",");

            String s12 = map.get("换油周期");
            s12 = s12.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            String[] sp12 = s12.split(",");

            String s13 = map.get("在用油品");
            s13 = s13.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
            String[] sp13 = s13.split(",");

            // 忽略该字段
            String s14 = map.get("用油点是否删除");

            try {

                for (int j = 0; j < sp9.length; j++) {
                    Map<String, String> resolveMap = newLinkedHashMap();
                    resolveMap.put("s1", s1);
                    resolveMap.put("s2", s2);
                    resolveMap.put("s3", s3);
                    resolveMap.put("s4", s4);
                    resolveMap.put("s5", s5);
                    resolveMap.put("s6", s6);
                    resolveMap.put("s7", s7);
                    resolveMap.put("s8", s8);
                    resolveMap.put("s9", sp9[j]);

                    String tmp10 = "";
                    String tmp11 = "";
                    String tmp12 = "";
                    String tmp13 = "";
                    // 防止别名、油量、换油周期、在用油品和用油点数组长度不一致
                    if (sp10.length < j + 1) {
                        tmp10 = "\"\"";
                        tmp11 = "\"\"";
                        tmp12 = "\"\"";
                        tmp13 = "\"\"";

                        resolveMap.put("s10", "");
                        resolveMap.put("s11", "");
                        resolveMap.put("s12", "");
                        resolveMap.put("s13", "");

                    } else {
                        if (Strings.isNullOrEmpty(sp10[j].trim())) {
                            tmp10 = "\"\"";
                            resolveMap.put("s10", "");
                        } else {
                            tmp10 = sp10[j].trim();
                            resolveMap.put("s10", tmp10);
                        }

                        if (Strings.isNullOrEmpty(sp11[j].trim())) {
                            tmp11 = "\"\"";
                            resolveMap.put("s11", "");
                        } else {
                            tmp11 = sp11[j].trim();
                            resolveMap.put("s11", tmp11);
                        }

                        if (Strings.isNullOrEmpty(sp12[j].trim())) {
                            tmp12 = "\"\"";
                            resolveMap.put("s12", "");
                        } else {
                            tmp12 = sp12[j].trim();
                            resolveMap.put("s12", tmp12);
                        }

                        if (Strings.isNullOrEmpty(sp13[j].trim())) {
                            tmp13 = "\"\"";
                            resolveMap.put("s13", "");
                        } else {
                            tmp13 = sp13[j].trim();
                            resolveMap.put("s13", tmp13);
                        }
                    }

                    System.out.println(
                            s1 +
                                    "\t" + s2 +
                                    "\t" + s3 +
                                    "\t" + s4 +
                                    "\t" + s5 +
                                    "\t" + s6 +
                                    "\t" + s7 +
                                    "\t" + s8 +
                                    "\t" + sp9[j] +
                                    "\t" + tmp10 +
                                    "\t" + tmp11 +
                                    "\t" + tmp12 +
                                    "\t" + tmp13 +
                                    "\t"
                    );

                    newData.add(resolveMap);
                }
            } catch (Exception e) {
                System.out.println("-----------------------------");
                System.out.println(s1 +
                        "\t" + s2 +
                        "\t" + s3 +
                        "\t" + s4 +
                        "\t" + s5 +
                        "\t" + s6 +
                        "\t" + s7 +
                        "\t" + s8 +
                        "\t" + s9 +
                        "\t" + s10 +
                        "\t" + s11 +
                        "\t" + s12 +
                        "\t" + s13 +
                        "\t"
                );
                System.out.println("-----------------------------");
                throw e;
            }
        }
    }
}
