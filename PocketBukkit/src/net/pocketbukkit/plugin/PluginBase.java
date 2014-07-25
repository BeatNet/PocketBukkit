/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.plugin;

import net.pocketbukkit.utility.ServerLogger;

public class PluginBase implements Plugin {
	private String loader;
	private String server;
	private boolean isEnabled = false;
	private boolean initialized = false;
	private String description;
	private String dataFolder;
	private String config;
	private String configFile;
	private String file;
	private ServerLogger logger = new ServerLogger();
	
	public void onLoad() {
		
	}
	
	public void onEnable() {
		
	}

	public void setEnabled(boolean isEnabled){
		if(this.isEnabled){
			this.onEnable();
		}else{
			this.onDisable();
		}
	}
	
	public boolean isEnabled() {
		return this.isEnabled == true;
	}

	public String getDataFolder() {
		return this.dataFolder;
	}

	public String getDescription() {
		return this.description;
	}

	public void getResource() {
		
	}

	public void saveResource() {
		
	}

	public void getResources() {
		
	}

	public void getConfig() {
		
	}

	public void saveConfig() {
		
	}

	public void saveDefaultConfig() {
		
	}

	public void reloadConfig() {
		
	}

	public String getServer() {
		return this.server;
	}

	public void getPluginLoader() {
		
	}

	public void onDisable() {
		
	}

	public void isDisabled() {
		
	}
}
