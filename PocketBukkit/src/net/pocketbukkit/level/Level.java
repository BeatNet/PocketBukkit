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
import net.pocketbukkit.Server;
import net.pocketbukkit.utility.ServerLogger;

public class Level {
	private static final ServerLogger logger = new ServerLogger();

	public static void createDefaultWorld() {
		String level = (String) (Server.server.getProperty("level-name"));
		logger.info("Generating new world...");
		File createDefaultLevel = new File("worlds/" + level);
		createDefaultLevel.mkdir();
		generateChunks(level);
	}

	public static void loadDefaultLevel() {
		
	}

	private static void generateChunks(String level) {
		
	}
}
