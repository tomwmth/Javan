package com.hawolt.data.api;

/**
 * Type of game mode that has a ranked ladder
 * associated with Tier and Division
 *
 * @see RankedTier
 * @see RankedDivision
 */

public enum RankedQueue {
    RANKED_SOLO_5x5, RANKED_FLEX_SR, @Deprecated RANKED_FLEX_TT
}
