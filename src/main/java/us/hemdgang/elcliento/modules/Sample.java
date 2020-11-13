package us.hemdgang.elcliento.modules;

import us.hemdgang.elcliento.values.Value;

public class Sample extends Module {

    // VALUES
    public Value<String> name = new Value<String>("nameInConfig", "defaultValue");
    public Value<Integer> size = new Value<Integer>("size", 2);
    public Value<Float> timing = new Value<Float>("timing", 1.2F);
    public Value<Boolean> nice = new Value<Boolean>("nice", false);

    public Sample() {
	super("Sample", Category.RENDER);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

}
