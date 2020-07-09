package com.gyq.area;

import com.google.common.base.Strings;
import com.gyq.utils.JsonUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 * @author qiu
 * @date 2020/7/9
 */
public class ViAreaTest {
  public static void main(String[] args) throws IOException {
    File src = new File("/Users/gaoyaqiu/Downloads/vi-VN.min.json");

    String jsonStr = FileUtils.readFileToString(src, Charset.forName("Utf-8"));
    Map<String, Object> objectMap = JsonUtil.json2LinkedHashMap(null, jsonStr);
    Map<String, Object> provinceMap = new LinkedHashMap<>();
    Map<String, Object> cityMap = new LinkedHashMap<>();
    Map<String, Object> countyMap = new LinkedHashMap<>();

    // 整体是一个 object，包含 province_list, city_list, county_list 三个 key。
    //每项以省市区编码作为 key，省市区名字作为 value。
    // 编码为 6 位数字，前两位代表省份，中间两位代表城市，后两位代表区县，
    // 以 0 补足 6 位。如北京编码为 11，以零补足 6 位，为 110000。
    int p_num = 10;
    for (Map.Entry<String, Object> entry: objectMap.entrySet()) {
      String provinceKey = entry.getKey();
      String provinceNewKey = Strings.padEnd(String.valueOf(p_num), 6, '0');
      provinceMap.put(provinceNewKey, provinceKey);

      // 处理城市数据
      int city_num = 1;
      Map<String, List<String>>  citys = (Map<String, List<String>>) entry.getValue();
      for (Map.Entry<String, List<String>> cityEntry: citys.entrySet()) {
        String cityKey = cityEntry.getKey();
        String cityNewNum = Strings.padStart(String.valueOf(city_num), 2, '0');
        String tmpCityKey = p_num + cityNewNum;
        String cityNewKey = tmpCityKey + "00";
        cityMap.put(cityNewKey, cityKey);

        // 处理区数据
        List<String> countys = (List)cityEntry.getValue();
        int county_num = 1;
        for (String countryKey : countys) {
          String countryNewNum = Strings.padStart(String.valueOf(county_num), 2, '0');
          String countryNewKey = tmpCityKey + countryNewNum;
          countyMap.put(countryNewKey, countryKey);
          county_num++;
        }
        city_num++;
      }
      p_num++;
    }
//    System.out.println(provinceMap);
//    System.out.println("==================");
//    System.out.println(cityMap);
//    System.out.println("==================");
//    System.out.println(countyMap);
    Map<String, Object> result = new LinkedHashMap<>();
    result.put("province_list", provinceMap);
    result.put("city_list", cityMap);
    result.put("county_list", countyMap);
    System.out.println(result);
    String json = JsonUtil.object2Json(result);
    File out = new File("/Users/gaoyaqiu/Downloads/vi-VN2.min.json");
    FileUtils.write(out, json, Charset.forName("Utf-8"));
  }
}
