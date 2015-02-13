package net.pocketbukkit.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import net.pocketbukkit.PocketBukkit;
import net.pocketbukkit.api.plugin.JavaScriptPlugin;
import net.pocketbukkit.api.plugin.PluginType;
import org.blockserver.Server;
import org.blockserver.api.Plugin;
import org.blockserver.api.PluginManager;
import org.blockserver.ui.ConsoleOut;
import org.blockserver.ui.Log4j2ConsoleOut;
import org.blockserver.ui.Logger;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PBPluginManager implements PluginManager {
	public final File pluginsFolder;

	private ArrayList<Plugin> plugins;
	private ScriptEngine scriptEngine;

	private Server server;
	private PocketBukkit pocketBukkit;

	public PBPluginManager(PocketBukkit pocketBukkit){//, File pluginsDir){
		this.pocketBukkit = pocketBukkit;
		this.scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
		pluginsFolder = new File("plugins");
		if(!pluginsFolder.exists() || !pluginsFolder.isDirectory()){
			pluginsFolder.mkdir();
		}
	}

	@Override
	public ArrayList<Plugin> getPlugins() {
		return plugins;
	}

	@Override
	public void loadPlugin(File file) {
		PluginType type = PluginType.getTypeByExtension(file.getName());
		if(type != null){
			if(type == PluginType.JAVASCRIPT){
				try {
					loadJavascript(file);
				} catch(ScriptException e){
					pocketBukkit.getLogger().error("Failed to load JavaScript plugin: "+file.getName());
					pocketBukkit.getLogger().error("At Line " + e.getLineNumber() + ", column " + e.getColumnNumber());
					pocketBukkit.getLogger().trace("ScriptException: "+e.getMessage());
					e.printStackTrace();
				} catch(FileNotFoundException e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void enablePlugin(Plugin plugin) {
		plugin.onEnable();
	}

	@Override
	public void disablePlugin(Plugin plugin) {
		plugin.onDisable();
	}

	public boolean validateExtension(String fileName){
		if(fileName.endsWith(".jar") || fileName.endsWith(".js") || fileName.endsWith(".class")){
			return true;
		} else {
			return false;
		}
	}

	public void loadPlugins(){
		pocketBukkit.getLogger().info("Searching for plugins...");
		File[] pluginsList = pluginsFolder.listFiles();
		ArrayList<File> validPlugins = new ArrayList<File>();
		for(File pluginFile: pluginsList){
			if(validateExtension(pluginFile.getName())){
				validPlugins.add(pluginFile);
			}
		}

		pocketBukkit.getLogger().info("Found "+validPlugins.size()+" plugins.");
		for(File plugin: validPlugins){
			loadPlugin(plugin);
		}
		pocketBukkit.getLogger().info("All plugins loaded.");
	}

	private void loadJavascript(File file) throws FileNotFoundException, ScriptException {
		pocketBukkit.getLogger().info("Loading JavaScript plugin: "+file.getName());
		scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
		scriptEngine.eval(new FileReader(file));
		Invocable inv = (Invocable) scriptEngine;
		JavaScriptPlugin jsp = new JavaScriptPlugin(pocketBukkit, scriptEngine, file);

		ConsoleOut out = new Log4j2ConsoleOut(jsp.getName());
		Logger pluginLogger = new Logger(out);

		jsp.onLoad(server, pluginLogger);

		try {
			jsp.onEnable();
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		plugins.add(jsp);

		pocketBukkit.getLogger().info(file.getName()+" loaded.");
	}
}
