package com.gyq.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gyq.utils.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一处理http调用所有方法返回类型（json）.
 *
 * @author gaoyaqiu
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonHttpResult<T> implements Serializable {

    private String errcode;

    private String errmsg;

    private long timestamp;

    private T result;

    public JsonHttpResult(String resCode, String resMsg, T resInfo) {
        this.errcode = resCode;
        this.errmsg = resMsg;
        this.timestamp = getTimestamp();
        this.result = resInfo;
    }

    public JsonHttpResult(String resCode, String resMsg) {
        this.errcode = resCode;
        this.errmsg = resMsg;
        this.timestamp = getTimestamp();
    }

    private long getTimestamp() {
        return DateUtil.getCurrentTimeMills();
    }

    private static final long serialVersionUID = 1L;
}
