package com.hawolt.exceptions;

/**
 * Created: 07/02/2023 11:07
 * Author: Twitter @hawolt
 **/

public class UnknownRoutingException extends RuntimeException {

    public UnknownRoutingException(String from) {
        super("Unable to fetch routing for: " + from);
    }
}
