package com.hawolt.exceptions;

/**
 * Indicates that no default value has been set to access the resource
 */

public class NoDefaultValueConfigured extends RuntimeException {

    public NoDefaultValueConfigured() {
        super("Please configure a default value to use this method");
    }
}
