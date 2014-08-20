/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.level;

import java.io.File;
import java.io.IOException;

import net.pocketbukkit.Server;
import net.pocketbukkit.utility.ServerLogger;

public class Level {
	public static void createDefaultLevel() {
		String level = (String) (Server.server.getProperty("level-name"));
		ServerLogger.info("[PocketBukkit] Generating new world...");
		File createDefaultLevel = new File("worlds/" + level);
		createDefaultLevel.mkdir();
		generateChunks(level);
	}
	
	public static void createNewLevel(){
		
	}

	private static void generateChunks(String level) {
		File data = new File("worlds/" + level + "/level.dat");
		ServerLogger.info("[PocketBukkit] No ops file found! Creating one...");
		try {
			data.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File region = new File("worlds/" + level + "/region/");
		region.mkdir();
		//TODO: Generate the chunks
	}

	public static void loadDefaultLevel() {
		//TODO: Load the default world
	}
	
	public static void loadOtherLevels(){
		
	}
	
	public static void loadAllLevels(){
		loadDefaultLevel();
		loadOtherLevels();
	}
}
