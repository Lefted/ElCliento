package us.hemdgang.elcliento.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.advancements.critereon.ConstructBeaconTrigger;

public class CommandManager {

    // ATTRIBUTES
    private final List<Command> commands = new ArrayList<>();

    // METHODS
    public void registerCommands() {
	// registerCommand(new BindCommand());
	// registerCommand(new ValueCommand());
	registerCommand(new ToggleCommand());
	// registerCommand(new ConfigCommand());
	// registerCommand(new FriendCommand());
    }

    public void registerCommand(final Command command) {
	commands.add(command);
    }

    public void callCommand(final String s) {
	final String[] strings = s.split(" ");
	commands.stream().filter(command -> this.getFilterCriteria(strings, command)).forEach(command -> command.execute(strings));
    }

    private boolean getFilterCriteria(String[] strings, Command command) {
	for (String name : command.getNames()) {
	    if (strings[0].equalsIgnoreCase("." + name)) {
		return true;
	    } else if (strings[0].equalsIgnoreCase("\\" + name)) {
		return true;
	    }
	}
	return false;
    }
}
