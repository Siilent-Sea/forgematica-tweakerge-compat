package dev.minecraftcompat.placement.mixin;

import dev.minecraftcompat.placement.PlacementDecision;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** Runs before the competing redirects and respects either mod's existing option. */
@Mixin(value = ServerGamePacketListenerImpl.class, priority = 1020)
public abstract class PlacementMixin {
    @Redirect(method = "handleUseItemOn(Lnet/minecraft/network/protocol/game/ServerboundUseItemOnPacket;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"))
    private Vec3 placementCompat$combineOptions(Vec3 hit, Vec3 center) {
        boolean forgematica = fi.dy.masa.litematica.config.Configs.Generic.ITEM_USE_PACKET_CHECK_BYPASS.getBooleanValue();
        boolean tweakerge = fi.dy.masa.tweakeroo.config.Configs.Generic.ITEM_USE_PACKET_CHECK_BYPASS.getBooleanValue();
        return PlacementDecision.bypass(forgematica, tweakerge) ? Vec3.ZERO : hit.subtract(center);
    }
}
