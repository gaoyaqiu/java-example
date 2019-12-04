package com.gyq.utils.ding;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gaoyaqiu
 * @date 2019/7/22
 */
@Data
public class TextMsg implements Serializable {
    private static final long serialVersionUID = 6391403654482325936L;

    private String msgtype;

    private Text text;
}
