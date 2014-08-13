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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;
import net.pocketbukkit.level.Level;
import net.pocketbukkit.network.TCPSocket;
//import net.pocketbukkit.network.UDPSocket; <-- This will be used for RCON
import net.pocketbukkit.utility.ServerLogger;

public class Server {
	public static Properties server = new Properties();
	public static boolean serverRunning = false;
	public static final String version = "Alpha_0.1.0dev";
	public static final String codename = "Baby Villager";
	public static final String api = "1.0.0";
	public static boolean defaultLevelExists = false;
	public static final String MinecraftVersion = "v0.9.5 alpha";
	public static final int protocol = 18;
	public static String serverName = "Minecraft: PE Server";
	public static String port = "19132";
	public static ServerLogger logger = new ServerLogger();

	public void run() throws IOException {
		Server.logger.info("[PocketBukkit] Server starting on: *:" + getServerPort() + ", on Minecraft Version: " + MinecraftVersion);
		startStopServer();
		serverRunning = true;
		Server.logger.info("[PocketBukkit] This server is running PocketBukkit version " + version + " (" + codename + ") (" + api + ")");
		checkFiles();
		enablePlugins();
		loadWorlds();
		Server.logger.info("[PocketBukkit] Done!");
		System.in.read();
	}

	public static String generateString(Random rng, String characters, int length) { 
	 	char[] rconPass = new char[length]; for (int i = 0; i < length; i++) { 
	 		rconPass[i] = characters.charAt(rng.nextInt(characters.length()));
	 	} 
	 	return new String(rconPass);
	 }
	
	public void checkFiles() throws IOException{
		Server.logger.info("[PocketBukkit] Loading server properties...");
		/* Create the files */
		File whitelist = new File("whitelist.txt");
		if(!whitelist.exists()){
			Server.logger.info("[PocketBukkit] No whitelist file found! Creating one...");
			whitelist.createNewFile();
		}
		File bannedips = new File("banned-ips.txt");
		if(!bannedips.exists()){
			Server.logger.info("[PocketBukkit] No banned ips file found! Creating one...");
			bannedips.createNewFile();
		}
		File bannedplayers = new File("banned-players.txt");
		if(!bannedplayers.exists()){
			Server.logger.info("[PocketBukkit] No banned players file found! Creating one...");
			bannedplayers.createNewFile();
		}
		File ops = new File("ops.txt");
		if(!ops.exists()){
			Server.logger.info("[PocketBukkit] No ops file found! Creating one...");
			ops.createNewFile();
		}
		File yaml = new File("PocketBukkit.yml");
		if(!yaml.exists()){
			Server.logger.info("[PocketBukkit] No PocketBukkit YAML found! Creating one...");
			yaml.createNewFile();
		}
		File properties = new File("server.properties");
		if(!properties.exists()){
			Server.logger.info("[PocketBukkit] No properties file found! Creating one...");
			try {
				server.setProperty("force-gamemode", "false");
				server.setProperty("auto-save", "true");
				server.setProperty("rcon.password", "RandomNumber");
				server.setProperty("enable-rcon", "true");
				server.setProperty("enable-query", "true");
				server.setProperty("level-type", "DEFAULT");
				server.setProperty("level-seed", "");
				server.setProperty("generator-settings", "");
				server.setProperty("level-name", "world");
				server.setProperty("pvp", "true");
				server.setProperty("difficulty", "1");
				server.setProperty("hardcore", "false");
				server.setProperty("spawn-mobs", "true");
				server.setProperty("gamemode", "0");
				server.setProperty("spawn-animals", "true");
				server.setProperty("allow-flight", "false");
				server.setProperty("max-players", "20");
				server.setProperty("view-distance", "8");
				server.setProperty("spawn-protection", "true");
				server.setProperty("announce-player-achievements", "true");
				server.setProperty("white-list", "false");
				server.setProperty("ram", "1024");
                                //Setting the IP to 127.0.0.1 will make players unable to join.
                                //It might confuse them.
				server.setProperty("ip", "");
				server.setProperty("port", "19132");
				server.setProperty("name", "PocketBukkit Server");
				File f = new File("server.properties");
				OutputStream out = new FileOutputStream( f );
				server.store(out, "PocketBukkit Configuration ");
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		File log = new File("server.log");
		if(!log.exists()){
			Server.logger.info("[PocketBukkit] No server log found! Creating one...");
			log.createNewFile();
		}
		
		/* Create the directories */
		File players = new File("players/");
		if(!players.exists()){
			Server.logger.info("[PocketBukkit] No players folder found! Creating one...");
			players.mkdir();
		}
		File plugins = new File("plugins/");
		if(!plugins.exists()){
			Server.logger.info("[PocketBukkit] No plugins folder found! Creating one...");
			plugins.mkdir();
		}
		File worlds = new File("worlds/");
		if(!worlds.exists()){
			Server.logger.info("[PocketBukkit] No worlds folder found! Creating one...");
			worlds.mkdir();
			defaultLevelExists = false;
		}else{
			String level = server.getProperty("level-name");
			File defaultlevel = new File("worlds/" + level);
			if(defaultlevel.exists() && defaultlevel.isDirectory()){
				defaultLevelExists = true;
			}else{
				defaultLevelExists = false;
			}
		}
	}


	public void getRam(){
		
		
		String GetRam = server.getProperty("port");
		if(GetRam =< "128"){
		Server.logger.info("[PocketBukkit] You need to have at least 128MBs of Ram for the server to work correctly!");  //If this has any errors oh well I will fix later need sleep! - SpiderPig	
		}
		
	
	}
	

	public void enablePlugins(){
		Server.logger.info("[PocketBukkit] Loading plugins...");
		//TODO: Check the plugins directory for any files and try to load the proper JAR files
	}
	
	public void loadWorlds(){
		Server.logger.info("[PocketBukkit] Loading worlds...");
		if(defaultLevelExists){
			
		}else{
			Level.createDefaultLevel();
		}
		Level.loadAllLevels();
	}

	public static String getServerPort() {
		return "19132";
		/*
		String serverPort = server.getProperty("port");
		if(serverPort == "19132" || serverPort == "19133" || serverPort == "19134" || serverPort == "19135" || serverPort == "19136" || serverPort == "19137" || serverPort == "19138" || serverPort == "19139" || serverPort == "19140" || serverPort == "19141" || serverPort == "19142" || serverPort == "19143" || serverPort == "19144" || serverPort == "19145"){
			
		}else{
			logger.fatal("[PocketBukkit] Server port must be between 19132 and 19145!");
		}
		return serverPort;
		*/
	}
	
	public void startStopServer(){
		try {
			Thread thread = new Thread();
			thread.start();
			TCPSocket.openTCPPort();
		} catch (IOException e) {
			Server.logger.error("[PocketBukkit] Unable to bind to port " + port + "!");
		}
	}

	public void stop() {
		startStopServer();
		serverRunning = false;
		System.exit(0);
	}
}
