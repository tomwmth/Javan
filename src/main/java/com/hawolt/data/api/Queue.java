package com.hawolt.data.api;

/**
 * @see <a href="https://static.developer.riotgames.com/docs/lol/queues.json">queues.json</a>
 */
public enum Queue {
    BB_5x5_NORMAL_ARAM(100),
    SR_5x5_NORMAL_DRAFT(400),
    SR_5x5_RANKED_SOLO(420, RankedQueue.RANKED_SOLO_5x5),
    SR_5x5_NORMAL_BLIND(430),
    SR_5x5_RANKED_FLEX(440, RankedQueue.RANKED_FLEX_SR),
    HA_5x5_NORMAL_ARAM(450),
    @Deprecated
    TT_3x3_NORMAL_BLIND(460),
    @Deprecated
    TT_3x3_RANKED_FLEX(470, RankedQueue.RANKED_FLEX_TT),
    SR_5x5_TOURNEY_CLASH(700),
    HA_5x5_TOURNEY_CLASH(720),
    SR_5x5_BOTS_INTRO(830),
    SR_5x5_BOTS_BEGINNER(840),
    SR_5x5_BOTS_INTERMEDIATE(850),
    SR_5x5_RGM_ARURF(900),
    HA_5x5_RGM_POROKING(920),
    SR_5x5_RGM_SPELLBOOK(1400),
    RW_2x2_RGM_ARENA(1700),
    SR_5x5_RGM_URF(1900),
    SR_TUTORIAL_ONE(2000),
    SR_TUTORIAL_TWO(2010),
    SR_TUTORIAL_THREE(2020);

    private final int id;
    private final RankedQueue rankedQueue;

    Queue(int id) {
        this(id, null);
    }

    Queue(int id, RankedQueue rankedQueue) {
        this.id = id;
        this.rankedQueue = rankedQueue;
    }

    public int getId() {
        return this.id;
    }

    public RankedQueue getRankedQueue() {
        return this.rankedQueue;
    }
}
