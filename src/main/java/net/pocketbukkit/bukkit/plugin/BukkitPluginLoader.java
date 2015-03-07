package net.pocketbukkit.bukkit.plugin;

import net.pocketbukkit.PluginLoader;
import net.pocketbukkit.PluginManager;
import net.pocketbukkit.PocketPlugin;
import net.pocketbukkit.bukkit.bridge.PocketServer;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BukkitPluginLoader implements PluginLoader{
	private final PluginManager mgr;
	private PocketServer server;
	private HashMap<JarFile, PluginDescriptionFile> cachedDesc = new HashMap<>();

	@SuppressWarnings("deprecation")
	public BukkitPluginLoader(PluginManager mgr){
		this.mgr = mgr;
		server = new PocketServer(mgr.getServer());
	}
	@Override
	public boolean acceptsPlugin(File file) throws IOException{
		if(!file.getAbsolutePath().toLowerCase().endsWith(".jar")){
			return false;
		}
		JarFile jar = new JarFile(file);
		return jar.getJarEntry("plugin.yml") != null;
	}
	@Override
	public PocketPlugin loadPlugin(File file) throws IOException{
		JarFile jar = new JarFile(file);
		try{
			PluginDescriptionFile desc = getDescription(jar); // pdf?
			removeCache(jar);
			initPlugin(jar, desc);
		}
		catch(InvalidDescriptionException e){
			return null;
		}
		return null;
	}

	private void initPlugin(JarFile jar, PluginDescriptionFile desc){
		// TODO
	}

	public PluginDescriptionFile getDescription(JarFile jarFile)
			throws IOException, InvalidDescriptionException{
		if(cachedDesc.containsKey(jarFile)){
			return cachedDesc.get(jarFile);
		}
		JarEntry entry = jarFile.getJarEntry("plugin.yml");
		PluginDescriptionFile desc = new PluginDescriptionFile(jarFile.getInputStream(entry));
		cachedDesc.put(jarFile, desc);
		return desc;
	}
	private void removeCache(JarFile jar){
		cachedDesc.remove(jar);
	}
}
