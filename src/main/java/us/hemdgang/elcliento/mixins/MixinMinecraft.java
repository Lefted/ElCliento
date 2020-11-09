package us.hemdgang.elcliento.mixins;

import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import us.hemdgang.elcliento.events.KeyPressedEvent;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Inject(method = "runTickKeyboard()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER))
    public void onKeyPressed(CallbackInfo ci) {
	final int key = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
	MinecraftForge.EVENT_BUS.post(new KeyPressedEvent(key));
    }
}
