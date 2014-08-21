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
			//TODO: Load all plugins found
		}else{
			pluginsDirectory.mkdir();
		}
	}
	
	public static boolean getPlugin(String pluginName, String fileEnd) {
		if(fileEnd == "jar" || fileEnd == "JAR" || fileEnd == "class" || fileEnd == "CLASS"){
			File plugin = new File(pluginsDirectory + pluginName + fileEnd);
			if(pluginsDirectory.exists()) {
				if(plugin.exists()) {
					return true;
				}else{
					return false;
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
