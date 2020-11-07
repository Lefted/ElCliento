package us.hemdgang.elcliento.modules;

import net.minecraft.client.Minecraft;
import us.hemdgang.elcliento.ElCliento;

public abstract class Module {

    // ATTRIBUTES
    private int keycode;
    private String name;
    private boolean enabled;
    private boolean visible;
    private Category category;

    protected Minecraft mc = Minecraft.getMinecraft();

    // CONSTRUCTOR
    public Module(String name, Category category) {
	this.name = name;
	this.category = category;
	this.enabled = false;
	this.keycode = 0;
    }

    // METHODS
    public abstract void onEnable();

    public abstract void onDisable();

    public void toggle() {
	this.setEnabled(!this.enabled);
    }

    public void setEnabled(boolean enabled) {
	// if nothing would change
	if (enabled == this.enabled) {
	    return;
	}

	this.enabled = enabled;
	if (this.enabled) {
	    this.onEnable();
	} else {
	    this.onDisable();
	}
	// if (ModuleConfig.initDone) {
	// ElCliento.instance.moduleConfig.saveModules();
	// }
    }

    public Category getCategory() {
	return category;
    }

    public int getKeycode() {
	return keycode;
    }

    public void setKeycode(int keycode) {
	this.keycode = keycode;
	// if (ModuleConfig.initDone) {
	// ElCliento.instance.moduleConfig.saveModules();
	// }
    }

    public String getName() {
	return name;
    }

    // TODO values
    // public Value getValue(final String valueName) {
    // for (final Field field : getClass().getDeclaredFields()) {
    // try {
    // field.setAccessible(true);
    //
    // final Object o = field.get(this);
    //
    // // System.out.println(field.getName());
    //
    // if (o instanceof Value) {
    // final Value value = (Value) o;
    //
    // if (value.getValueName().equalsIgnoreCase(valueName))
    // return value;
    // }
    // } catch (IllegalAccessException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // return null;
    // }
    //
    // public List<Value> getValues() {
    // final List<Value> values = new ArrayList<>();
    //
    // for (final Field field : getClass().getDeclaredFields()) {
    // try {
    // field.setAccessible(true);
    //
    // final Object o = field.get(this);
    //
    // if (o instanceof Value)
    // values.add((Value) o);
    // } catch (IllegalAccessException e) {
    // e.printStackTrace();
    // }
    // }
    //
    // return values;
    // }
}
