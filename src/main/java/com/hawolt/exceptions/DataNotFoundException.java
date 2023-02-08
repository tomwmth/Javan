package com.hawolt.exceptions;

/**
 * Created: 07/02/2023 14:33
 * Author: Twitter @hawolt
 **/

public class DataNotFoundException extends Exception {
    public DataNotFoundException(String url) {
        super(url);
    }
}
