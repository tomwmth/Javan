package com.hawolt.dto.spectator.v4;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class GameCustomizationObject extends DataTransferObject {
    private final String category, content;

    public GameCustomizationObject(JSONObject customization) {
        super(customization);
        this.category = customization.getString("category");
        this.content = customization.getString("content");
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }
}
