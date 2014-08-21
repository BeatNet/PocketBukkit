/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.plugin;

import java.io.File;

import net.pocketbukkit.utility.ServerLogger;

public class PluginLoader {
	public static final File pluginsDirectory = new File("plugins/");
	public static final String Class = ".class"; 
	public static final String Jar = ".jar";
	
	public static void load() {
		if(pluginsDirectory.exists()) {
			File[] plugins = pluginsDirectory.listFiles();
			for(File plugin : plugins) {
				if(plugin.isFile()) {
					File pluginFile = new File("" + pluginsDirectory + plugin + "");
					Class<? extends File> pluginClass = pluginFile.getClass();
				}
			}
		}else{
			pluginsDirectory.mkdir();
			ServerLogger.info("[PocketBukkit] No plugins were found in the plugins directory.");
		}
	}
	
	public static boolean getPlugin(String pluginName, String fileType) {
		if(fileType == "jar" || fileType == "JAR" || fileType == "class" || fileType == "CLASS"){
			if(pluginsDirectory.exists()) {
				if(fileType == "jar" || fileType == "JAR") {
					File plugin = new File(pluginsDirectory + pluginName + Jar);
					if(plugin.isFile()) {
						return true;
					}else{
						return false;
					}
				}else{
					if(fileType == "class" || fileType == "CLASS") {
						File plugin = new File(pluginsDirectory + pluginName + Class);
						if(plugin.isFile()) {
							return true;
						}else{
							return false;
						}
					}else{
						return false;
					}
				}
			}else{
				pluginsDirectory.mkdir();
				return false;
			}
		}else{
			ServerLogger.fatal("A plugin has requested to find a plugin using an invalid file ending!");
			return false;
		}
	}
}
