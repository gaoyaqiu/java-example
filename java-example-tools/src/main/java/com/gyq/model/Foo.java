package com.gyq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author gaoyaqiu
 */
@Getter
@Setter
@AllArgsConstructor
public class Foo implements Serializable {

    private static final long serialVersionUID = -6848592916989479269L;
    private long id;

    private String name;

}
