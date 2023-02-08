package com.hawolt.dto.match.v5.perks;

import org.json.JSONObject;

/**
 * Created: 07/02/2023 14:54
 * Author: Twitter @hawolt
 **/

public class PerkStyleSelectionDto {
    private final int perk, var1, var2, var3;

    public PerkStyleSelectionDto(JSONObject perk) {
        this.perk = perk.getInt("perk");
        this.var1 = perk.getInt("var1");
        this.var2 = perk.getInt("var2");
        this.var3 = perk.getInt("var3");
    }

    public int getPerk() {
        return perk;
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public int getVar3() {
        return var3;
    }

    @Override
    public String toString() {
        return "PerkStyleSelectionDto{" +
                "perk=" + perk +
                ", var1=" + var1 +
                ", var2=" + var2 +
                ", var3=" + var3 +
                '}';
    }
}
