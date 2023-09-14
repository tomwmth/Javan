package com.hawolt.util;

import com.hawolt.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created: 14/09/2023 01:02
 * Author: Twitter @hawolt
 **/

public class QueryStructure {
    private final Map<String, Boolean> parameters;

    public QueryStructure(Map<String, Boolean> parameters) {
        this.parameters = parameters;
    }

    public boolean isValid(HttpRequest request) {
        Map<String, String> map = request.getQueryParameterMap();
        for (String key : map.keySet()) {
            if (parameters.containsKey(key)) continue;
            return false;
        }
        for (String parameter : parameters.keySet()) {
            boolean mandatory = parameters.get(parameter);
            if (!mandatory || map.containsKey(parameter)) continue;
            return false;
        }
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Map<String, Boolean> parameters = new HashMap<>();

        public Builder addParameter(String name, boolean mandatory) {
            parameters.put(name, mandatory);
            return this;
        }

        public QueryStructure build() {
            return new QueryStructure(parameters);
        }
    }
}
