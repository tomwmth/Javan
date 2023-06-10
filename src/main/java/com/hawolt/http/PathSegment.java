package com.hawolt.http;

/**
 * Created: 10/06/2023 01:19
 * Author: Twitter @hawolt
 **/

public class PathSegment {
    private final Object o;
    private final boolean predefined;

    public static PathSegment build(Object o, boolean predefined) {
        return new PathSegment(o, predefined);
    }

    public PathSegment(Object o, boolean predefined) {
        this.predefined = predefined;
        this.o = o;
    }

    public Object getObject() {
        return o;
    }

    public boolean isPredefined() {
        return predefined;
    }
}
