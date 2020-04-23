package com.teammetallurgy.atum.world.biome;

import com.teammetallurgy.atum.init.AtumFeatures;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class SandPlainsBiome extends AtumBiome {

    public SandPlainsBiome() {
        super(new Builder("sand_plains", 30));
        this.deadwoodRarity = 0.01D;
        super.addDefaultSpawns(this);
        super.addCamelSpawning(this);
        AtumFeatures.Default.addCarvers(this);
        AtumFeatures.Default.addSprings(this);
    }
}