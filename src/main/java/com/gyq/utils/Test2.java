package com.gyq.utils;

import com.google.common.base.Strings;

/**
 * @auther gaoyaqiu
 */
public class Test2 {

    public static void main(String[] args) {

        String str = "117\t\"重庆江润\"\t\"汽车零部件\"\t\"压铸机\"\t6000\t\"重庆渝江压铸有限公司岚峰\"\t\"6号机\"\t伊之密\t[\"液压系统\", \"润滑系统\"]\t[\"\", \"\"]\t[1000, 5]\t[false, false]\t[\"壳牌海德力68\", \"通拿220\"]\t[24, 1]\n";

        String[] strings = str.split("\t");
        // 删除无用数据
        String[] sp = remove(strings, 11);

        String s8 = sp[8];
        s8 = s8.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        String[] sp8 = s8.split(",");

        String s9 = sp[9];
        s9 = s9.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        String[] sp9 = s9.split(",");

        String s10 = sp[10];
        s10 = s10.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        String[] sp10 = s10.split(",");

        String s11 = sp[11];
        s11 = s11.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        String[] sp11 = s11.split(",");

        String s12 = sp[12];
        s12 = s12.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");
        String[] sp12 = s12.split(",");

        for (int j = 0; j < sp8.length; j++) {
            String tmp = sp9[j];
            if (Strings.isNullOrEmpty(tmp.trim())) {
                tmp = "\"\"";
            }
            System.out.println(sp[0] +
                    "\t" + sp[1] +
                    "\t" + sp[2] +
                    "\t" + sp[3] +
                    "\t" + sp[4] +
                    "\t" + sp[5] +
                    "\t" + sp[6] +
                    "\t" + sp[7] +
                    "\t" + sp8[j] +
                    "\t\t" + tmp +
                    "\t" + sp10[j] +
                    "\t" + sp11[j] +
                    "\t" + sp12[j] +
                    "\t"
            );
        }
    }


    public static String[] remove(String[] strs, int index) {
        String[] strings = new String[strs.length - 1];
        for (int i = 0, j = i; i < strings.length; i++, j++) {
            if (i == index) {
                j = i + 1;
            }
            strings[i] = strs[j];
        }
        return strings;
    }

}
