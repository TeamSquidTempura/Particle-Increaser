package net.logiench.particleincreaser;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class Commands {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("pi")
                    .then(ClientCommandManager.literal("toggle").executes(context -> {
                        ParticleIncreaser.toggle();
                        return 1;
                    }))
                    .then(ClientCommandManager.argument("value", IntegerArgumentType.integer()).executes(context -> {
                        ClientPlayerEntity player = MinecraftClient.getInstance().player;
                        if (player != null) {
                            ParticleIncreaser.value = IntegerArgumentType.getInteger(context, "value");
                            player.sendMessage(Text.of("Set the multiplier to " + ParticleIncreaser.value), false);
                        }
                        return 1;
                    }))
            );
        });
    }
}
