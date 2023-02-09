package com.hawolt.exceptions;

/**
 * Indicates that the Riot API has no data associated to our request
 */
public class DataNotFoundException extends Exception {
    public DataNotFoundException(String url) {
        super(url);
    }
}
