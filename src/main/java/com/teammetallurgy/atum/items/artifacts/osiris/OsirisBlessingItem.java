package com.teammetallurgy.atum.items.artifacts.osiris;

import com.teammetallurgy.atum.Atum;
import com.teammetallurgy.atum.api.AtumMats;
import com.teammetallurgy.atum.api.God;
import com.teammetallurgy.atum.api.IArtifact;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class OsirisBlessingItem extends HoeItem implements IArtifact {

    public OsirisBlessingItem() {
        super(AtumMats.NEBU, -3, 0.0F, new Item.Properties().rarity(Rarity.RARE).tab(Atum.GROUP));
    }

    @Override
    public God getGod() {
        return God.OSIRIS;
    }
}