package com.gyq.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author gaoyaqiu
 */
@Getter
@Setter
public class Bar implements Serializable {

    private static final long serialVersionUID = -6071335317267442452L;
    private long id;

    private String name;

}
