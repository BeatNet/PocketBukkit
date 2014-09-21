/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.level;

import org.blockserver.Server;
import org.blockserver.level.generator.GenerationSettings;

public class Level {
	public static Server server;
	
	public Level() {
		try {
			server = Server.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the Default Level
	 */
	public static org.blockserver.level.Level getDefaultLevel() {
		return server.getDefaultLevel();
	}
	
	/**
	 * Returns Level</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to find
	 */
	public static org.blockserver.level.Level getLevel(String level) {
		return server.getLevel(level, false, false);
	}
	
	/**
	 * Returns Level</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to find</br>
	 *  + load - Load level (boolean)
	 */
	public static org.blockserver.level.Level getLevel(String level, boolean load) {
		return server.getLevel(level, load, false);
	}
	
	
	/**
	 * Returns Level</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to find</br>
	 *  + load - Load level (boolean)</br>
	 *  + generate - Generate level (boolean)
	 */
	public static org.blockserver.level.Level getLevel(String level, boolean load, boolean generate) {
		return server.getLevel(level, load, generate);
	}
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to load
	 */
	public static boolean loadLevel(String level) {
		return server.loadLevel(level, false);
	}
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to load</br>
	 *  + generate - Generate level
	 */
	public static boolean loadLevel(String level, boolean generate) {
		return server.loadLevel(level, generate);
	}
	
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to create
	 */
	public static boolean createLevel(String level) {
		return server.generateLevel(level);
	}
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * Parameters:</br>
	 *  + level - Level to create</br>
	 *  + settings - Generator settings
	 */
	public static boolean createLevel(String level, GenerationSettings settings) {
		return server.generateLevel(level, settings);
	}
}
