package us.hemdgang.elcliento;

import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ElCliento.MODID, name = ElCliento.NAME, version = ElCliento.VERSION)
public class ElCliento {
    
    // CONSTANTS
    public static final String MODID = "elcliento";
    public static final String NAME = "ElCliento";
    public static final String VERSION = "b1";

    private static Logger logger;

    // METHODS
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	logger = event.getModLog();
	logger.info("FMLPreInitialization");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
    
    public static Logger getLogger() {
	return logger;
    }
}
