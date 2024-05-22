package net.logiench.particleincreaser;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticleIncreaser implements ModInitializer {
    Logger log = LoggerFactory.getLogger(ParticleIncreaser.class);
    public static boolean mode;
    public static int value;
    @Override
    public void onInitialize() {
        mode = true;
        value = 10;
        Commands.register();
        log.info("enabled");
    }
    public static void toggle() {
        mode = !mode;
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Toggled the mode to " + mode));
        }
    }
}
