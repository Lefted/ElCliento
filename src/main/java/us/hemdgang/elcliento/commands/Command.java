package us.hemdgang.elcliento.commands;

public abstract class Command {

    // ATTRIBUTES
    private String[] names;

    // CONSTRUCTOR
    public Command(String... names) {
	this.names = names;
    }

    // METHODS
    public String[] getNames() {
	return names;
    }

    public abstract void execute(String[] strings);
}
