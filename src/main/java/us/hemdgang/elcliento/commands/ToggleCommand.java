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
		ChatLogger.INSTANCE.log("§c§lError: §r§aThe entered module does not exist.");
		return;
	    }

	    module.setEnabled(!module.isEnabled());
	    ChatLogger.INSTANCE.log("§cToggled module.");
	    return;
	}

	ChatLogger.INSTANCE.log("§c§lSyntax: §r§a.toggle <module>");
    }

}
