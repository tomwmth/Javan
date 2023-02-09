package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class GameCustomizationObject {
    private final String category, content;

    public GameCustomizationObject(JSONObject customization) {
        this.category = customization.getString("category");
        this.content = customization.getString("content");
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "GameCustomizationObject{" +
                "category='" + category + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
