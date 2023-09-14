package com.hawolt.util;

/**
 * Created: 14/09/2023 01:41
 * Author: Twitter @hawolt
 **/

public interface ExceptionalIterator<T> {
    boolean hasNext();

    T next() throws Exception;
}
