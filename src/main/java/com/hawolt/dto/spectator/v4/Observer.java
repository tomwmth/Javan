package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 11:25
 * Author: Twitter @hawolt
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
