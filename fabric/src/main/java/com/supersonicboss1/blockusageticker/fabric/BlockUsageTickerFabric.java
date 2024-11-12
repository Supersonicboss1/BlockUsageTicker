package com.supersonicboss1.blockusageticker.fabric;

import net.fabricmc.api.ModInitializer;

import com.supersonicboss1.blockusageticker.BlockUsageTicker;

public final class BlockUsageTickerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        BlockUsageTicker.init();
    }
}
