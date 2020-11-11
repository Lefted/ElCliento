package us.hemdgang.elcliento.commands;

import org.lwjgl.input.Keyboard;

import us.hemdgang.elcliento.modules.Module;
import us.hemdgang.elcliento.modules.ModuleManager;
import us.hemdgang.elcliento.utils.ChatLogger;

public class BindCommand extends Command {

    // CONSTRUCTOR
    public BindCommand() {
	super("bind");
    }

    // METHODS
    @Override
    public void execute(String[] strings) {
	if (strings.length > 2) {
	    final Module module = ModuleManager.getModuleByName(strings[1]);

	    if (module == null) {
		ChatLogger.INSTANCE.log("§c§lError: §r§aThe entered module does not exist.");
		return;
	    }
	    final int key = Keyboard.getKeyIndex(strings[2].toUpperCase());
	    module.setKeycode(key);
	    
	    ChatLogger.INSTANCE.log("§cThe keybind of §a§l" + module.getName() + " §r§cwas set to §a§l" + Keyboard.getKeyName(key) + "§c.");
	    return;
	}

	ChatLogger.INSTANCE.log("§c§lSyntax: §r§a.bind <module> <key>");
    }
}
