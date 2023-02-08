package com.hawolt.dto.match.v5.timeline.events;

/**
 * Created: 08/02/2023 13:34
 * Author: Twitter @hawolt
 **/

public enum EventType {
    PAUSE_END,
    WARD_PLACED,
    ITEM_DESTROYED,
    CHAMPION_KILL,
    SKILL_LEVEL_UP,
    LEVEL_UP,
    CHAMPION_SPECIAL_KILL,
    ITEM_PURCHASED,
    ITEM_UNDO,
    BUILDING_KILL,
    ITEM_SOLD,
    GAME_END,
    UNKNOWN;

    private static final EventType[] EVENT_TYPES = EventType.values();

    public static EventType valueOfOrElse(String name, EventType type) {
        for (EventType eventType : EVENT_TYPES) {
            if (eventType.name().equals(name)) {
                return eventType;
            }
        }
        return type;
    }
}
