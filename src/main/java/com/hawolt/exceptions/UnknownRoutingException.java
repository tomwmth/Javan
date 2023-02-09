package com.hawolt.exceptions;

/**
 * Indicates that no routing is mapped for the provided Value
 */

public class UnknownRoutingException extends RuntimeException {

    public UnknownRoutingException(String from) {
        super("Unable to fetch routing for: " + from);
    }
}
