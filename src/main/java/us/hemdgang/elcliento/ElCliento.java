package us.hemdgang.elcliento;

import java.io.IOException;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import us.hemdgang.config.ModuleConfig;
import us.hemdgang.elcliento.commands.CommandManager;
import us.hemdgang.elcliento.modules.Fullbright;
import us.hemdgang.elcliento.modules.ModuleManager;

@Mod(modid = ElCliento.MODID, name = ElCliento.NAME, version = ElCliento.VERSION)
public class ElCliento {

    // CONSTANTS
    public static final String MODID = "elcliento";
    public static final String NAME = "ElCliento";
    public static final String VERSION = "b1";

    private static Logger logger;

    private ModuleManager moduleManager;
    public CommandManager commandManager;
    public ModuleConfig moduleConfig;

    // INSTANCE
    public static ElCliento instance;

    // METHODS
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	logger = event.getModLog();
	logger.info("FMLPreInitialization");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	instance = instance == null ? new ElCliento() : instance;
	
	instance.moduleManager = new ModuleManager();
	instance.commandManager = new CommandManager();
	// todo move stuff so constructors that are called multiple time dont fuck up, see utilitymod
	instance.moduleManager.registerAllModules();
	instance.commandManager.registerCommands();

	instance.moduleConfig = new ModuleConfig();
	try {
	    instance.moduleConfig.loadModules();
	    instance.moduleConfig.initDone = true;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	Runtime.getRuntime().addShutdownHook(new Thread(() -> onShutdown()));
    }
    
    private void onShutdown() {
	// reset brightness
	ModuleManager.getModule(Fullbright.class).onDisable();
    }

    public static Logger getLogger() {
	return logger;
    }
}
