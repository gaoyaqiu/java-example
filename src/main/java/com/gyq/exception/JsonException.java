package com.gyq.exception;

import java.io.IOException;

/**
 * json异常.
 *
 * @auther gaoyaqiu
 */
public class JsonException extends BaseException {
    private static final long serialVersionUID = 3589264847881174997L;

    public JsonException(final IOException cause) {
        super(cause);
    }

    public JsonException(Exception ex) {
        super(ex);
    }
}
