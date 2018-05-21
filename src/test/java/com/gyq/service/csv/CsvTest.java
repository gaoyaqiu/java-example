package com.gyq.service.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gaoyaqiu
 * @date 2018/5/21
 */
public class CsvTest {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/gaoyaqiu/Downloads/DetailedUsageCsv.May.19.04.31.2951_2017_12.csv"));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");

                System.out.println(item[16].replaceAll("\"", ""));
                break;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
