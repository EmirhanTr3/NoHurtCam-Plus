package com.blake_jh.nohurtcamplus.mixin;

import com.blake_jh.nohurtcamplus.NoHurtCamPlus;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(at = @At("HEAD"), method = "tiltViewWhenHurt(Lnet/minecraft/client/util/math/MatrixStack;F)V", cancellable = true)
    public void bobViewWhenHurt(MatrixStack matrixStack_1, float float_1, CallbackInfo ci) {
        if (!NoHurtCamPlus.hurtCam) ci.cancel();
    }
}
