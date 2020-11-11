package us.hemdgang.elcliento.events;

import net.minecraftforge.fml.common.eventhandler.Event;

public class KeyPressedEvent extends Event {

    // ATTRIBUTES
    private int key;
    private boolean state;

    // CONSTRUCTOR
    public KeyPressedEvent(int key, boolean state) {
	this.key = key;
	this.state = state;
    }

    // METHODS
    public int getKey() {
	return key;
    }

    /**
     * Gets the state of the key that generated the
     * current event
     *
     * @return True if key was down, or false if released
     */
    public boolean getEventKeyState() {
	    return state;
    }
}
