package us.hemdgang.elcliento.commands;

import us.hemdgang.elcliento.ElCliento;
import us.hemdgang.elcliento.modules.Module;
import us.hemdgang.elcliento.modules.ModuleManager;
import us.hemdgang.elcliento.utils.ChatLogger;
import us.hemdgang.values.Value;

/**
 * Project: LiquidBase ----------------------------------------------------------- Copyright \u00A7 2017 | CCBlueX | All rights reserved.
 */
public class ValueCommand extends Command {

    public ValueCommand() {
	super("value");
    }

    @Override
    public void execute(String[] strings) {
	if (strings.length > 3) {
	    final Module module = ModuleManager.getModuleByName(strings[1]);

	    if (module == null) {
		ChatLogger.INSTANCE.log("\u00A7c\u00A7lError: \u00A7r\u00A7aThe entered module does not exist.");
		return;
	    }

	    final Value value = module.getValue(strings[2]);

	    if (value == null) {
		ChatLogger.INSTANCE.log("\u00A7c\u00A7lError: \u00A7r\u00A7aThe entered value does not exist.");
		return;
	    }

	    if (value.getObject() instanceof Float) {
		final float newValue = Float.parseFloat(strings[3]);
		value.setObject(newValue);
		ChatLogger.INSTANCE.log("\u00A7cThe value of \u00A7a\u00A7l" + module.getName() + " \u00A78(\u00A7a\u00A7l" + value.getValueName() + "\u00A78) \u00A7c was set to \u00A7a\u00A7l" + newValue
		    + "\u00A7c.");
	    } else if (value.getObject() instanceof Boolean) {
		final boolean newValue = Boolean.parseBoolean(strings[3]);
		value.setObject(newValue);
		ChatLogger.INSTANCE.log("\u00A7cThe value of \u00A7a\u00A7l" + module.getName() + " \u00A78(\u00A7a\u00A7l" + value.getValueName() + "\u00A78) \u00A7c was set to \u00A7a\u00A7l" + newValue
		    + "\u00A7c.");
	    } else if (value.getObject() instanceof Integer) {
		final int newValue = Integer.parseInt(strings[3]);
		value.setObject(newValue);
		ChatLogger.INSTANCE.log("\u00A7cThe value of \u00A7a\u00A7l" + module.getName() + " \u00A78(\u00A7a\u00A7l" + value.getValueName() + "\u00A78) \u00A7c was set to \u00A7a\u00A7l" + newValue
		    + "\u00A7c.");
	    } else if (value.getObject() instanceof String) {
		final String newValue = strings[3];
		value.setObject(newValue);
		ChatLogger.INSTANCE.log("\u00A7cThe value of \u00A7a\u00A7l" + module.getName() + " \u00A78(\u00A7a\u00A7l" + value.getValueName() + "\u00A78) \u00A7c was set to \u00A7a\u00A7l" + newValue
		    + "\u00A7c.");
	    } else {
		ChatLogger.INSTANCE.log("\u00A7c\u00A7lError: \u00A7r\u00A7aCould not identify:" + value.getObject().getClass().getName());
	    }
	    return;
	}

	ChatLogger.INSTANCE.log("\u00A7c\u00A7lSyntax: \u00A7r\u00A7a.value <module> <valuename> <new_value>");
    }
}