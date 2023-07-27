package net.joey.eternalglow.player;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerSpawnEventHandler {

    public static void registerPlayerSpawnAndRespawnEvent() {
        // Register the event listener for player respawn event.
        ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
            if (entity instanceof ServerPlayerEntity) {
                // Delay the glow effect application slightly to ensure it's visible.
                serverWorld.getServer().execute(() -> applyGlowEffect((ServerPlayerEntity) entity));
            }
        });
    }

    private static void applyGlowEffect(ServerPlayerEntity player) {
        // Add a glow effect to the player.
        StatusEffectInstance glowEffect = new StatusEffectInstance(StatusEffects.GLOWING, -1, 255, false,
                false);
        player.addStatusEffect(glowEffect);

    }

}