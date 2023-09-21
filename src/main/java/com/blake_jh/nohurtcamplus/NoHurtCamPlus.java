package com.blake_jh.nohurtcamplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NoHurtCamPlus implements ModInitializer {
    public static boolean hurtCam = true;
    MinecraftClient mc = MinecraftClient.getInstance();
    @Override
    public void onInitialize() {
        KeyBinding k = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.noHurtCam+.toggle",
                GLFW.GLFW_KEY_F8,
                "category.noHurtCam+"));

        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            if (k.wasPressed()) {
                if (hurtCam) {
                    hurtCam = false;
                    mc.inGameHud.setOverlayMessage(Text.of("Enabled Hurtcam"), false);
                }
                else {
                    hurtCam = true;
                    mc.inGameHud.setOverlayMessage(Text.of("Disabled Hurtcam"), false);
                }
            }
        });
    }
}
