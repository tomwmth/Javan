package com.hawolt.util;

import com.hawolt.http.HttpRequest;

import java.util.List;
import java.util.function.Function;

/**
 * Created: 14/09/2023 00:57
 * Author: Twitter @hawolt
 **/

public abstract class Paginator<T> implements ExceptionalIterator<T> {
    private final Function<String, List<T>> function;
    private final HttpRequest request;
    private int index, childIndex;
    private final int offset;
    private List<T> list;

    public Paginator(HttpRequest request, Function<String, List<T>> function) {
        this.offset = Integer.parseInt(request.getQueryParameterMap().getOrDefault(getPaginatorOffsetKey(), "0"));
        this.function = function;
        this.request = request;
    }

    @Override
    public boolean hasNext() {
        return list == null || (childIndex != list.size() || list.size() == getElementCount());
    }

    @Override
    public T next() throws Exception {
        if (list == null || childIndex == list.size()) {
            this.request.updateQueryParameter(getPaginatorOffsetKey(), String.valueOf(offset + ((index++) * getElementCount())));
            this.list = function.apply(request.getAsString().body());
            this.childIndex = 0;
        }
        return list.get(childIndex++);
    }

    public abstract String getPaginatorOffsetKey();

    public abstract int getElementCount();
}
