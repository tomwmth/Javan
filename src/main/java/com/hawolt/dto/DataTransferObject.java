package com.hawolt.dto;

import org.json.JSONObject;

/**
 * Created: 13/09/2023 23:59
 * Author: Twitter @hawolt
 **/

public class DataTransferObject {
    protected final JSONObject sourceReference;

    public DataTransferObject(JSONObject sourceReference) {
        this.sourceReference = sourceReference;
    }

    public JSONObject getSourceReference() {
        return sourceReference;
    }

    public String toString(int identFactor) {
        return sourceReference.toString(identFactor);
    }

    @Override
    public String toString() {
        return sourceReference.toString();
    }
}
