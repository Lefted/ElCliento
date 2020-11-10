package us.hemdgang.elcliento.modules;

import us.hemdgang.elcliento.modules.Category;
import us.hemdgang.elcliento.modules.Module;
import us.hemdgang.values.Value;

public class Fullbright extends Module {

    // ATTRIBUTES
    private float oldGamma;
    
    // CONSTRUCTOR
    public Fullbright() {
	super("Fullbright", Category.RENDER);
    }

    // METHODS
    @Override
    public void onEnable() {
	this.oldGamma = mc.gameSettings.gammaSetting;
	mc.gameSettings.gammaSetting = 40.0F;
    }

    @Override
    public void onDisable() {
	mc.gameSettings.gammaSetting = this.oldGamma;
    }

}
