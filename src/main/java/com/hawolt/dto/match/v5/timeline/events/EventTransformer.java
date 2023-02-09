package com.hawolt.dto.match.v5.timeline.events;

import com.hawolt.dto.match.v5.timeline.events.impl.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Handles events of the timeline
 **/

public class EventTransformer {
    private static final Map<EventType, Function<JSONObject, Event>> transformers = new HashMap<EventType, Function<JSONObject, Event>>() {{
        put(EventType.UNKNOWN, UnknownEvent::new);
        put(EventType.PAUSE_END, PauseEndEvent::new);
        put(EventType.WARD_PLACED, WardPlacedEvent::new);
        put(EventType.ITEM_DESTROYED, ItemDestroyedEvent::new);
        put(EventType.CHAMPION_KILL, ChampionKillEvent::new);
        put(EventType.SKILL_LEVEL_UP, SkillLevelUpEvent::new);
        put(EventType.LEVEL_UP, LevelUpEvent::new);
        put(EventType.CHAMPION_SPECIAL_KILL, ChampionSpecialKillEvent::new);
        put(EventType.ITEM_PURCHASED, ItemPurchasedEvent::new);
        put(EventType.ITEM_UNDO, ItemUndoEvent::new);
        put(EventType.BUILDING_KILL, BuildingKillEvent::new);
        put(EventType.ITEM_SOLD, ItemSoldEvent::new);
        put(EventType.GAME_END, GameEndEvent::new);
    }};

    public static Event transform(Event event) {
        return transformers.get(event.getEventType()).apply(event.getRawEvent());
    }
}
