package us.hemdgang.elcliento;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import us.hemdgang.elcliento.modules.ModuleManager;

@Mod(modid = ElCliento.MODID, name = ElCliento.NAME, version = ElCliento.VERSION)
public class ElCliento {

    // CONSTANTS
    public static final String MODID = "elcliento";
    public static final String NAME = "ElCliento";
    public static final String VERSION = "b1";

    private static Logger logger;

    private ModuleManager moduleManager;

    // INSTANCE
    public static ElCliento instance;

    // CONSTRUCTOR
    public ElCliento() {
	this.moduleManager = new ModuleManager();
    }

    // METHODS
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	logger = event.getModLog();
	logger.info("FMLPreInitialization");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	instance = new ElCliento();
    }

    public static Logger getLogger() {
	return logger;
    }
}
