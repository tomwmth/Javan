package com.hawolt.exceptions;

import java.io.IOException;

/**
 * Created: 07/02/2023 21:10
 * Author: Twitter @hawolt
 **/

public class WrappedIOException extends RuntimeException {
    private final IOException origin;

    public WrappedIOException(IOException origin) {
        this.origin = origin;
    }

    public IOException unwrap() {
        return origin;
    }
}
