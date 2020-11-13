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
		ChatLogger.INSTANCE.log("\u00A7c\u00A7lError: \u00A7r\u00A7aThe entered module does not exist.");
		return;
	    }
	    final int key = Keyboard.getKeyIndex(strings[2].toUpperCase());
	    module.setKeycode(key);
	    
	    ChatLogger.INSTANCE.log("\u00A7cThe keybind of \u00A7a\u00A7l" + module.getName() + " \u00A7r\u00A7cwas set to \u00A7a\u00A7l" + Keyboard.getKeyName(key) + "\u00A7c.");
	    return;
	}

	ChatLogger.INSTANCE.log("\u00A7c\u00A7lSyntax: \u00A7r\u00A7a.bind <module> <key>");
    }
}
