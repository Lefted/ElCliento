package us.hemdgang.elcliento.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ChatLogger {

    // INSTANCE
    public static final ChatLogger INSTANCE = new ChatLogger();

    // ATTRIBUTES
    private Minecraft mc = Minecraft.getMinecraft();

    // METHODS
    public void log(String msg) {
	mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(msg));
    }

}
