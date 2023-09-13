package com.hawolt.dto.spectator.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class Observer extends DataTransferObject {
    private final String encryptionKey;

    public Observer(JSONObject observer) {
        super(observer);
        this.encryptionKey = observer.getString("encryptionKey");
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }
}
