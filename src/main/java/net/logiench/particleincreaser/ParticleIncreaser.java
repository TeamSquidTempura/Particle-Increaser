package net.logiench.particleincreaser;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticleIncreaser implements ModInitializer {
    Logger log = LoggerFactory.getLogger(ParticleIncreaser.class);
    @Override
    public void onInitialize() {
        log.info("enabled");
    }
}
