package us.hemdgang.elcliento.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import us.hemdgang.elcliento.ElCliento;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen extends Gui {

    @Inject(method = "sendChatMessage(Ljava/lang/String;Z)V", at = @At("HEAD"), cancellable = true)
    public void onSendChatMessage(String msg, boolean addToChat, CallbackInfo callbackInfo) {
	if (msg.startsWith("\\") || msg.startsWith(".")) {
	    ElCliento.instance.commandManager.callCommand(msg);
	    // enables use of up
	    Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages().add(msg);
	    callbackInfo.cancel();
	}
    }

}
