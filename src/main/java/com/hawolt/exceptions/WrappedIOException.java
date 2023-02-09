package com.hawolt.exceptions;

import java.io.IOException;


/**
 * Wraps an IOException as a RuntimeException to allow handling at later stage
 */

public class WrappedIOException extends RuntimeException {
    private final IOException origin;

    public WrappedIOException(IOException origin) {
        this.origin = origin;
    }

    public IOException unwrap() {
        return origin;
    }
}
