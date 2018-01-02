package com.gyq.exception;

import java.io.IOException;

/**
 * 网络主机异常.
 *
 * @auther gaoyaqiu
 */
public class HostException extends BaseException {
    private static final long serialVersionUID = 3589264847881174997L;

    public HostException(final IOException cause) {
        super(cause);
    }
}
