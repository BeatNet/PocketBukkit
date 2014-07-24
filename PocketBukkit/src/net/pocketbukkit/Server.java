/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit;

import java.util.Random;
import net.pocketbukkit.utility.ServerLogger;

public class Server {
	public static boolean serverRunning;

	public static final String version = "Alpha_0.1dev";
	public static final String codename = "Baby Villager";
	public static final String api = "0.0.1";
	public static final String MinecraftVersion = "v0.9.4alpha";
	public static final int serverPort = 19132;

	private ServerLogger logger = new ServerLogger();

	public void run() {
		serverRunning = true;
		this.logger.info("Server starting on: *:" + serverPort + ", on Minecraft Version: " + MinecraftVersion);
		this.logger.info("This server is running PocketBukkit version " + version + " (" + codename + ") (" + api + ")");
		checkFiles();
		enablePlugins();
		loadWorlds();
		this.logger.info("Done!");
	}

	 public static String generateString(Random rng, String characters, int length) { 
	 	char[] rconPass = new char[length]; for (int i = 0; i < length; i++) { 
	 		rconPass[i] = characters.charAt(rng.nextInt(characters.length()));
	 	} 
	 	return new String(rconPass);
	 }
	
	public void checkFiles(){
		this.logger.info("Loading server properties...");
		//TODO: Check the default server files and generate them if non existent
	}
	
	public void enablePlugins(){
		this.logger.info("Loading plugins...");
		//TODO: Check the plugins directory for any files and try to load the proper JAR files
	}
	
	public void loadWorlds(){
		this.logger.info("Loading worlds...");
		//TODO: Load levels (start with default level) and generate them if non existent
	}
	
	public void openSocket(){
		
	}

	public void stop() {
		serverRunning = false;
		System.exit(0);
	}

	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}
}
