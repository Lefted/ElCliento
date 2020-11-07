package us.hemdgang.elcliento.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import us.hemdgang.elcliento.ElCliento;

@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu extends GuiScreen{

    @Inject(method = "initGui", at = @At("HEAD"))
    private void onMainMenu(CallbackInfo ci) {
	ElCliento.getLogger().info("Main menu created");
    }
    
}
