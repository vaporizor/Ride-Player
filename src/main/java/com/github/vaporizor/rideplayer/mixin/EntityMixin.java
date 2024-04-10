package com.github.vaporizor.rideplayer.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAttachmentType;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export=true)
@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "getPassengerAttachmentPos(Lnet/minecraft/entity/Entity;L/net/minecraft/entity/Entity;Lnet/minecraft/entity/EntityAttachments;)L/net/minecraft/util/math/Vec3d;", at = @At("HEAD"), cancellable = true)
    private static void getPassengerAttachmentPos(Entity vehicle, Entity passenger, EntityAttachments attachments, CallbackInfoReturnable<Vec3d> cir) {
        int i = vehicle.getPassengerList().indexOf(passenger);
        cir.setReturnValue(attachments.getPointOrDefault(EntityAttachmentType.PASSENGER, i, vehicle.getYaw()).subtract(0, 1, 0));
    }
}
