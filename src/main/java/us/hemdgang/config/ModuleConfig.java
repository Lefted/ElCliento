package us.hemdgang.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.hemdgang.elcliento.ElCliento;
import us.hemdgang.elcliento.modules.Module;
import us.hemdgang.elcliento.modules.ModuleManager;
import us.hemdgang.values.Value;

public class ModuleConfig {

    // ATTRIBUTES
    private final File dir = new File(Minecraft.getMinecraft().gameDir, ElCliento.NAME);
    private final File saveFile = new File(dir, "moduleconfig.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public boolean initDone = false;

    // CONSTRUCTOR
    public ModuleConfig() {
	dir.mkdirs();
    }

    // METHODS
    public void saveModules() {
	if (!saveFile.exists()) {
	    try {
		saveFile.createNewFile();
	    } catch (IOException e) {
		System.out.println("moduleconfig.json already exists");
	    }
	}

	final JsonObject jsonObject = new JsonObject();

	for (final Module module : ModuleManager.getModuleList()) {
	    final JsonObject moduleJson = new JsonObject();

	    moduleJson.addProperty("enabled", module.isEnabled());
	    moduleJson.addProperty("keycode", module.getKeycode());
	    moduleJson.addProperty("visible", module.isVisible());

	    for (final Value value : module.getValues()) {
		if (value.getObject() instanceof Number)
		    moduleJson.addProperty(value.getValueName(), (Number) value.getObject());
		else if (value.getObject() instanceof Boolean)
		    moduleJson.addProperty(value.getValueName(), (Boolean) value.getObject());
		else if (value.getObject() instanceof String)
		    moduleJson.addProperty(value.getValueName(), (String) value.getObject());
	    }

	    jsonObject.add(module.getName(), moduleJson);
	}

	PrintWriter printWriter;
	try {
	    printWriter = new PrintWriter(saveFile);
	    printWriter.println(gson.toJson(jsonObject));
	    printWriter.flush();
	    printWriter.close();
	} catch (FileNotFoundException e) {
	    System.err.println("Error occured while writing moduleconfig.json");
	    e.printStackTrace();
	}
    }

    // sets all module's state and values
    public void loadModules() throws IOException {
	if (!saveFile.exists()) {
	    saveFile.createNewFile();
	    saveModules();
	    return;
	}

	final BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile));
	final JsonElement jsonElement = gson.fromJson(bufferedReader, JsonElement.class);

	if (jsonElement instanceof JsonNull)
	    return;

	final JsonObject jsonObject = (JsonObject) jsonElement;

	for (final Module module : ModuleManager.getModuleList()) {
	    if (!jsonObject.has(module.getName()))
		continue;

	    final JsonElement moduleElement = jsonObject.get(module.getName());

	    if (moduleElement instanceof JsonNull)
		continue;

	    final JsonObject moduleJson = (JsonObject) moduleElement;

	    if (moduleJson.has("enabled")) {
		module.setEnabled(moduleJson.get("enabled").getAsBoolean());
	    }
	    if (moduleJson.has("keycode")) {
		module.setKeycode(moduleJson.get("keycode").getAsInt());
	    }
	    if (moduleJson.has("visible")) {
		module.setKeycode(moduleJson.get("keycode").getAsInt());
		module.setVisible(moduleJson.get("visible").getAsBoolean());
	    }
	    for (final Value value : module.getValues()) {
		if (!moduleJson.has(value.getValueName()))
		    continue;

		if (value.getObject() instanceof Float) {
		    value.setObject(moduleJson.get(value.getValueName()).getAsFloat());
		} else if (value.getObject() instanceof Double)
		    value.setObject(moduleJson.get(value.getValueName()).getAsDouble());
		else if (value.getObject() instanceof Integer)
		    value.setObject(moduleJson.get(value.getValueName()).getAsInt());
		else if (value.getObject() instanceof Long)
		    value.setObject(moduleJson.get(value.getValueName()).getAsLong());
		else if (value.getObject() instanceof Byte)
		    value.setObject(moduleJson.get(value.getValueName()).getAsByte());
		else if (value.getObject() instanceof Boolean)
		    value.setObject(moduleJson.get(value.getValueName()).getAsBoolean());
		else if (value.getObject() instanceof String)
		    value.setObject(moduleJson.get(value.getValueName()).getAsString());
	    }
	}
	this.saveModules();
    }

    public static boolean isInitDone() {
	return ElCliento.instance != null && ElCliento.instance.moduleConfig != null && ElCliento.instance.moduleConfig.initDone;
    }
}