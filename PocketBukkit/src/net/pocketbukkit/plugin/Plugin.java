/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.plugin;

public interface Plugin {

	/*
	 * Load plugins and check if they are enabled
	 */
	public void onLoad();
	
	public void onEnable();

	public boolean isEnabled();
	
	/*
	 * Get the plugins data folder to save files
	 */
	public String getDataFolder();

	/*
	 * Check the plugins YAML for its description
	 */
	public String getDescription();

	/*
	 * Get the plugins embedded resource
	 */
	public void getResource();

	public void saveResource();

	public void getResources();

	/*
	 * Find, save, and load/reload a plugins config
	 */
	public void getConfig();

	public void saveConfig();

	public void saveDefaultConfig();

	public void reloadConfig();

	/*
	 * Get the servers info
	 */
	public String getServer();

	/*
	 * Find out what loaded the plugin
	 */
	public void getPluginLoader();

	/*
	 * Disable plugins and check if they are disabled
	 */
	public void onDisable();

	public void isDisabled();
}
