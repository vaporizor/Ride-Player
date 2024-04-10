package com.github.vaporizor.rideplayer.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAttachmentType;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "getPassengerAttachmentPos(Lnet/minecraft/entity/EntityL/net/minecraft/entity/EntityLnet/minecraft/entity/EntityAttachments;)L/net/minecraft/util/math/Vec3d;", at = @At("TAIL"))
    private static Vec3d getPassengerAttachmentPos(Entity vehicle, Entity passenger, EntityAttachments attachments) {
        int i = vehicle.getPassengerList().indexOf(passenger);
        return attachments.getPointOrDefault(EntityAttachmentType.PASSENGER, i, vehicle.getYaw()).subtract(0, 1, 0);
    }
}
