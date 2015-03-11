package net.pocketbukkit.bukkit.plugin;

import net.pocketbukkit.plugin.PluginLoader;
import net.pocketbukkit.plugin.PluginManager;
import net.pocketbukkit.plugin.PocketPlugin;
import net.pocketbukkit.bukkit.bridge.PocketServer;
import net.pocketbukkit.bukkit.plugin.js.JavaScriptFile;
import net.pocketbukkit.bukkit.plugin.js.JavaScriptPlugin;
import net.pocketbukkit.wrapper.LoggerWrapper;
import org.blockserver.ui.Log4j2ConsoleOut;
import org.blockserver.ui.Logger;
import org.bukkit.Server;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BukkitPluginLoader implements PluginLoader{
	private final PluginManager mgr;
	private PocketServer server;
	private HashMap<JarFile, PluginDescriptionFile> cachedDesc = new HashMap<>();
    private HashMap<File, PluginDescriptionFile> cachedDescJS = new HashMap<>();
    private ArrayList<Plugin> plugins = new ArrayList<Plugin>();

	@SuppressWarnings("deprecation")
	public BukkitPluginLoader(PluginManager mgr){
		this.mgr = mgr;
		server = (PocketServer) mgr.getBukkitServer();
	}
	@Override
	public boolean acceptsPlugin(File file) throws IOException{
		if(file.getAbsolutePath().toLowerCase().endsWith(".jar")){
            JarFile jar = new JarFile(file);
            return jar.getJarEntry("plugin.yml") != null;
		} else if(file.getName().endsWith(".js")){
            //TODO: Actually validate file
            return true;
        }
        return false;
	}
	@Override
	public PocketPlugin loadPlugin(File file) throws IOException{
        if(file.getName().endsWith(".jar")) {
            JarFile jar = new JarFile(file);
            try {
                PluginDescriptionFile desc = getJavaDescription(jar); // pdf?
                removeCache(jar);
                initJarPlugin(jar, desc);
            } catch (InvalidDescriptionException e) {
                return null;
            }
            return null;
        } else if(file.getName().endsWith(".js")){
            try {
                PluginDescriptionFile desc = getJavaScriptDescription(file);
                removeCache(file);
                initJavaScriptPlugin(file, desc);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        return null;
	}

	private void initJarPlugin(JarFile jar, PluginDescriptionFile desc){
		// TODO
	}

    private void initJavaScriptPlugin(File script, PluginDescriptionFile desc) throws FileNotFoundException {
        JavaScriptFile javaScriptFile = null;
        try {
            javaScriptFile = new JavaScriptFile(script, new ScriptEngineManager().getEngineByName("nashorn"));
            Log4j2ConsoleOut out = new Log4j2ConsoleOut(desc.getName());
            Logger pluginLogger = new Logger(out);
            LoggerWrapper pluginLoggerWrapper = new LoggerWrapper(pluginLogger);

            JavaScriptPlugin jsPlugin = new JavaScriptPlugin(javaScriptFile, desc, this, pluginLoggerWrapper);
            plugins.add(jsPlugin);

            server.getLogger().info("Enabling JavaScriptPlugin "+desc.getName()+", version "+desc.getVersion()+".");
            jsPlugin.onLoad();
            jsPlugin.onEnable();

        } catch (ScriptException e) {
            server.getLogger().severe("Failed to load JavaScriptPlugin "+desc.getName()+": ScriptException at line "+e.getLineNumber()+", column "+e.getColumnNumber());
            e.printStackTrace();
        }
    }

	public PluginDescriptionFile getJavaDescription(JarFile jarFile)
			throws IOException, InvalidDescriptionException{
		if(cachedDesc.containsKey(jarFile)){
			return cachedDesc.get(jarFile);
		}
		JarEntry entry = jarFile.getJarEntry("plugin.yml");
		PluginDescriptionFile desc = new PluginDescriptionFile(jarFile.getInputStream(entry));
		cachedDesc.put(jarFile, desc);
		return desc;
	}

    public PluginDescriptionFile getJavaScriptDescription(File scriptFile) throws IOException, ScriptException {
        if(cachedDescJS.containsKey(scriptFile)){
            return cachedDescJS.get(scriptFile);
        }
        BufferedReader in = new BufferedReader(new FileReader(scriptFile));
        if(in.readLine().equalsIgnoreCase("/***")){
            String line = "";
            String name = null, version = null, mainClass = null;
            while((line = in.readLine()) != null){
                if(line != "*/") {
                    if(line.startsWith("name")){
                        name = line.replaceAll("name: ", "");
                    } else if(line.startsWith("version")){
                        version = line.replaceAll("version: ", "");
                    } else if(line.startsWith("mainClass")){
                        mainClass = line.replaceAll("mainClass: ", "");
                    }
                } else {
                    break;
                }
            }

            PluginDescriptionFile desc = new PluginDescriptionFile(name, version, mainClass);
            cachedDescJS.put(scriptFile, desc);
            return desc;
        } else {
            throw new ScriptException("Script does not contain description header!", scriptFile.getName(), 1, 1);
        }
    }
    public Server getServer(){ return server; }
	private void removeCache(JarFile jar){
		cachedDesc.remove(jar);
	}
    private void removeCache(File file){ cachedDescJS.remove(file); }
}
