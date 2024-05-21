package net.logiench.particleincreaser;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class Commands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("pi")
                    .then(CommandManager.literal("toggle").executes(context -> {
                        ParticleIncreaser.toggle();
                        return 0;
                    }))
                    .then(CommandManager.literal("amount"))
                    .then(CommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
                        PlayerEntity p = MinecraftClient.getInstance().player;
                        ParticleIncreaser.value = IntegerArgumentType.getInteger(context, "value");
                        if (p != null) {
                            p.sendMessage(Text.of("set the multiplier to " + ParticleIncreaser.value));
                        }
                        return 0;
                    }))
            );
        }));
    }
}
