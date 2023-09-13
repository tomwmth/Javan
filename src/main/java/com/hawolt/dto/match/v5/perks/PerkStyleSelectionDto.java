package com.hawolt.dto.match.v5.perks;

import com.hawolt.dto.DataTransferObject;
import org.json.JSONObject;

/**
 * Wrapper for Data transfer Object as described on the API reference
 **/

public class PerkStyleSelectionDto extends DataTransferObject {
    private final int perk, var1, var2, var3;

    public PerkStyleSelectionDto(JSONObject perk) {
        super(perk);
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
}
