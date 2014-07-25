/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

import net.pocketbukkit.network.UDPSocket;
import net.pocketbukkit.utility.ServerLogger;

public class Server {
	public static boolean serverRunning = false;
	public static final String version = "Alpha_0.1.2dev";
	public static final String codename = "Baby Villager";
	public static final String api = "1.0.0";
	public static final String MinecraftVersion = "v0.9.5 alpha";
	public static final int protocol = 18;
	public static String serverName = "Minecraft: PE Server";
	private ServerLogger logger = new ServerLogger();

	public void run() {
		serverRunning = true;
		this.logger.info("Server starting on: *:" + getServerPort() + ", on Minecraft Version: " + MinecraftVersion);
		this.logger.info("This server is running PocketBukkit version " + version + " (" + codename + ") (" + api + ")");
		checkFiles();
		enablePlugins();
		loadWorlds();
		startStopServer();
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

	public int getServerPort() {
		return 19132;
	}
	
	public void startStopServer(){
		if(serverRunning || !serverRunning){
			try {
				ServerSocket sock = new ServerSocket(getServerPort());
				if(!serverRunning){
					sock.accept();
				}else{
					sock.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				this.logger.fatal("Unable to bind to port " + getServerPort());
			}
		}else{
			this.logger.fatal("An error occured while checking socket status!");
		}
	}

	public void stop() {
		serverRunning = false;
		System.exit(0);
	}
}
