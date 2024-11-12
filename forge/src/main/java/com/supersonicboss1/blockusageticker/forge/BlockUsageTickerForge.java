package com.supersonicboss1.blockusageticker.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.supersonicboss1.blockusageticker.BlockUsageTicker;

@Mod(BlockUsageTicker.MOD_ID)
public final class BlockUsageTickerForge {
    public BlockUsageTickerForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(BlockUsageTicker.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        BlockUsageTicker.init();
    }
}
