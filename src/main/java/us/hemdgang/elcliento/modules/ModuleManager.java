package us.hemdgang.elcliento.modules;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
=======
import net.minecraftforge.common.MinecraftForge;
>>>>>>> refs/heads/feature_values
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.hemdgang.elcliento.ElCliento;
import us.hemdgang.elcliento.events.KeyPressedEvent;
<<<<<<< HEAD
=======
import us.hemdgang.modules.Fullbright;
>>>>>>> refs/heads/feature_values

public class ModuleManager {

    // ATTRIBUTES
    private static final List<Module> modules = new ArrayList<Module>();;
    private KeybindListener keybindListener;
    private RenderArrayList arrayList;

    // CONSTRUCTOR
    public ModuleManager() {
	this.keybindListener = new KeybindListener();
	this.arrayList = new RenderArrayList();
    }

    // METHODS
    public void registerAllModules() {
	// #############################
	// registering modules goes here
	// e.g. this.registerModule(new Killaura());
	// ##############################
	this.registerModule(new Fullbright());
    }

    private void registerModule(Module module) {
	if (!this.modules.contains(module)) {
	    this.modules.add(module);
	} else {
	    ElCliento.getLogger().error(String.format("Module %s already registered", module.getName()));
	}
    }

    public static List<Module> getModuleList() {
	return modules;
    }

    // by class
    public static Module getModule(Class<?> clazz) {
	for (final Module module : modules) {
	    if (module.getClass() == clazz) {
		return module;
	    }
	}
	return null;
    }

    // by name
    public static Module getModuleByName(String moduleName) {
	for (final Module module : modules) {
	    if (module.getName().equalsIgnoreCase(moduleName.trim())) {
		return module;
	    }
	}
	return null;
    }

    private class KeybindListener {

	public KeybindListener() {
	    MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onKeyInputEvent(KeyPressedEvent event) {
	    for (Module module : modules) {
		if (module.getKeycode() == event.getKey()) {
		    module.toggle();
		}
	    }
	}
    }

    private class RenderArrayList {

	public RenderArrayList() {
	    // EventManager.register(this);
	}

	// public void onRender2D(Render2DEvent event) {
	// ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
	// Minecraft.getMinecraft().entityRenderer.setupOverlayRendering();
	// GlStateManager.enableBlend();
	//
	// // LUNACY
	// if (ClientConfig.isEnabled() && ClientConfig.getArraylistMode() != 0) {
	//
	// // ARRAY LIST
	// renderArrayList(scaledresolution);
	// }

	// private void renderArrayList(ScaledResolution resolution) {
	// resolution.getScaledWidth();
	// resolution.getScaledHeight();
	// final FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	//
	// // MODULE NAMES
	// List<String> display = new ArrayList();
	// for (Module module : ModuleManager.getModuleList()) {
	// if (module.isEnabled()) {
	// display.add(String.valueOf(module.getName()));
	// }
	// }
	//
	// // SORT
	// Collections.sort(display, new Comparator<String>() {
	// @Override
	// public int compare(String m1, String m2) {
	// if (fr.getStringWidth(m1) > fr.getStringWidth(m2)) {
	// return -1;
	// }
	// if (fr.getStringWidth(m1) < fr.getStringWidth(m2)) {
	// return 1;
	// }
	// return 0;
	// }
	// });

	// // RENDER
	// int i = 0;
	// for (String string : display) {
	// int width = fr.getStringWidth(string);
	// int posX = resolution.getScaledWidth() - width - 2;
	// int posY = 10 * i + 2;
	//
	// if (ClientConfig.getArraylistMode() >= 3) {
	// if (i == 0) {
	// Gui.drawRect(posX - 2, posY - 2, posX + width + 2, posY + 9, 0xEE252838);
	// } else {
	// Gui.drawRect(posX - 2, posY - 1, posX + width + 2, posY + 9, 0xEE252838);
	// }
	// }
	// if (ClientConfig.getArraylistMode() == 1 || ClientConfig.getArraylistMode() == 3) {
	// fr.drawString(string, posX, posY, ColorUtils.rainbowEffect(200000000L, 1.0F).getRGB());
	// } else if (ClientConfig.getArraylistMode() == 2 || ClientConfig.getArraylistMode() == 4) {
	// fr.drawStringWithShadow(string, posX, posY, ColorUtils.rainbowEffect(200000000L, 1.0F).getRGB());
	// }
	// i++;
	// }
	// display.clear();
	// GL11.glColor4f(1F, 1F, 1F, 1F);
	// }
    }
}
