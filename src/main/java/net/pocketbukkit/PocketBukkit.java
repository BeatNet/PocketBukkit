/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit;

import java.io.File;

import net.pocketbukkit.addon.AddonManager;
import net.pocketbukkit.api.PluginManager;
import net.pocketbukkit.module.ModuleManager;

import org.blockserver.Server;

public class PocketBukkit{
	public static PluginManager plugins;
	public static ModuleManager modules;
	public static AddonManager addons;

	public static void main(Server server){
		File base = server.getDataDir();
		plugins = new PluginManager(server, new File(base, "plugins"));
		modules = new ModuleManager(server, new File(base, "modules"));
		addons = new AddonManager(server, new File(base, "addons"));
	}
}
