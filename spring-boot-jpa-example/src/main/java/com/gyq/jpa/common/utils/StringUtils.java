package com.gyq.jpa.common.utils;


import java.util.regex.Pattern;

public class StringUtils {

    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");

    public static boolean isInt(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        return INT_PATTERN.matcher(str).matches();
    }

}
