package com.github.vaporizor.rideplayer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RidePlayerMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Ride Player");
    @Override
    public void onInitialize() {
        LOGGER.info("Ride your players with Ride Player!");
    }
}
