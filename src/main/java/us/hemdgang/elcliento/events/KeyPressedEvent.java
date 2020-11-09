package us.hemdgang.elcliento.events;

import net.minecraftforge.fml.common.eventhandler.Event;

public class KeyPressedEvent extends Event {

    // ATTRIBUTES
    private int key;

    // CONSTRUCTOR
    public KeyPressedEvent(int key) {
	super();
	this.key = key;
    }

    // METHODS
    public int getKey() {
	return key;
    }
}
