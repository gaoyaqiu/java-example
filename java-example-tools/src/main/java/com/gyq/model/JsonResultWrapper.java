package com.gyq.model;

import com.gyq.constant.MessageConstant;

/**
 * @auther gaoyaqiu
 */
public class JsonResultWrapper<T> extends JsonHttpResult<T> {

    private MessageConstant msgdefined;

    public JsonResultWrapper(String resCode, String resMsg, T resInfo) {
        super(resCode, resMsg, resInfo);
    }

    public JsonResultWrapper(String resCode, String resMsg) {
        super(resCode, resMsg);
    }


    public JsonResultWrapper(MessageConstant msgdefined, T data) {
        this(msgdefined.getValue(), msgdefined.getDesc(), data);
    }

    public JsonResultWrapper(MessageConstant msgdefined) {
        this(msgdefined.getValue(), msgdefined.getDesc(), null);
    }

}
