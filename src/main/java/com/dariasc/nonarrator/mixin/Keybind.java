package com.dariasc.nonarrator.mixin;

import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class Keybind {

	// ignore any calls to NARRATOR.cycle() inside the onKey() method
	@Inject(method = "onKey", cancellable = true,
			at = @At(value = "INVOKE", target = "Lnet/minecraft/client/options/CyclingOption;cycle(Lnet/minecraft/client/options/GameOptions;I)V"))
	private void cycle(CallbackInfo callbackInfo) {
		callbackInfo.cancel();
	}

}
