package com.hawolt.util;

import java.util.Map;

/**
 * Created: 14/09/2023 01:34
 * Author: Twitter @hawolt
 **/

public abstract class Query {

    protected final Map<String, Object> parameters;

    protected Query(Map<String, Object> parameters) {
        this.parameters = parameters;
    }


    public Map<String, Object> getParameters() {
        return parameters;
    }
}
