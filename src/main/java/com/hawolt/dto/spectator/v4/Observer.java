package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Observer {
    private final String encryptionKey;

    public Observer(JSONObject observer) {
        this.encryptionKey = observer.getString("encryptionKey");
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    @Override
    public String toString() {
        return "Observer{" +
                "encryptionKey='" + encryptionKey + '\'' +
                '}';
    }
}
