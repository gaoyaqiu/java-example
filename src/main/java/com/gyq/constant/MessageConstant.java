package com.gyq.constant;


/**
 * @auther gaoyaqiu
 */
public enum MessageConstant {
    // 成功
    SUCCESS("200", "成功"),

    // READ excel
    ERR_READ_EXCEL("10800", "读取excel错误"),
    ERR_READ_EXCEL_TEMPLATE("10801", "读取excel模板错误");


    private String code;

    private String message;

    MessageConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getValue() {
        return this.code;
    }

    public String getDesc() {
        return this.message;
    }
}
