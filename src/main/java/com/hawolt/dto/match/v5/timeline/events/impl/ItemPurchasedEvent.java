package com.hawolt.dto.match.v5.timeline.events.impl;

import com.hawolt.dto.match.v5.timeline.events.Event;
import org.json.JSONObject;

/**
 * Created: 08/02/2023 13:46
 * Author: Twitter @hawolt
 **/

public class ItemPurchasedEvent extends Event {
    private final String type;
    private final int participantId, itemId, timestamp;

    public ItemPurchasedEvent(JSONObject event) {
        super(event);
        this.type = event.getString("type");
        this.participantId = event.getInt("participantId");
        this.itemId = event.getInt("itemId");
        this.timestamp = event.getInt("timestamp");
    }

    public String getType() {
        return type;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ItemPurchasedEvent{" +
                "type='" + type + '\'' +
                ", participantId=" + participantId +
                ", itemId=" + itemId +
                ", timestamp=" + timestamp +
                ", rawEvent=" + rawEvent +
                ", type=" + type +
                '}';
    }
}