package com.hawolt.dto.spectator.v4;

import org.json.JSONObject;

/**
 * Created: 08/02/2023 11:26
 * Author: Twitter @hawolt
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
