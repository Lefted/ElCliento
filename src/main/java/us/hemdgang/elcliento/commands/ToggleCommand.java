package us.hemdgang.elcliento.commands;

import us.hemdgang.elcliento.modules.Module;
import us.hemdgang.elcliento.modules.ModuleManager;
import us.hemdgang.elcliento.utils.ChatLogger;

public class ToggleCommand extends Command {

    // CONSTRUCTOR
    public ToggleCommand() {
	super("toggle", "t");
    }

    // METHODS
    @Override
    public void execute(String[] strings) {
	if (strings.length > 1) {
	    final Module module = ModuleManager.getModuleByName(strings[1]);

	    if (module == null) {
		ChatLogger.INSTANCE.log("\u00A7c\u00A7lError: \u00A7r\u00A7aThe entered module does not exist.");
		return;
	    }

	    module.setEnabled(!module.isEnabled());
	    ChatLogger.INSTANCE.log(String.format("\u00A77Toggled %s: [%s\u00A77]", module.getName(), module.isEnabled() ? "\u00A7aON" : "\u00A7cOFF"));
	    return;
	}

	ChatLogger.INSTANCE.log("\u00A7c\u00A7lSyntax: \u00A7r\u00A7a.toggle <module>");
    }

}
