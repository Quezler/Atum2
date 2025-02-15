package com.teammetallurgy.atum.integration.theoneprobe;

import com.teammetallurgy.atum.Atum;
import com.teammetallurgy.atum.blocks.base.DoorAtumBlock;
import mcjty.theoneprobe.api.*;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static mcjty.theoneprobe.api.IProbeConfig.ConfigMode.EXTENDED;
import static mcjty.theoneprobe.api.IProbeConfig.ConfigMode.NORMAL;
import static mcjty.theoneprobe.api.TextStyleClass.MODNAME;

public class AtumProbeInfoProvider implements IBlockDisplayOverride {

    @Override
    public boolean overrideStandardInfo(ProbeMode mode, IProbeInfo probeInfo, Player player, Level world, BlockState blockState, IProbeHitData data) {
        IProbeConfig config = TOPSupport.getProbeConfig();

        if (mode != ProbeMode.DEBUG && !this.show(mode, config.getShowSilverfish())) {
            if (blockState.getBlock() instanceof DoorAtumBlock) {
                ResourceLocation location = Objects.requireNonNull(blockState.getBlock().getRegistryName());
                if (location.toString().contains("limestone")) {
                    location = new ResourceLocation(location.toString().replace("_door", ""));
                    ItemStack door = new ItemStack(ForgeRegistries.ITEMS.getValue(location));
                    probeInfo.horizontal()
                            .item(door)
                            .vertical()
                            .itemLabel(door)
                            .text(new TextComponent(MODNAME + StringUtils.capitalize(Atum.MOD_ID)));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean show(ProbeMode mode, IProbeConfig.ConfigMode cfg) {
        return cfg == NORMAL || (cfg == EXTENDED && mode == ProbeMode.EXTENDED);
    }
}