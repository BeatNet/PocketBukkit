/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import net.pocketbukkit.format.Color;

public class ServerLogger{
	public static void info(String string) {
		System.out.println("[INFO] " + string);
		try {
			BufferedWriter log = new BufferedWriter(new FileWriter("server.log"));
			log.write("[INFO] " + string + "\n");
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void warning(String string) {
		System.out.println("[WARNING] " + string);
		try {
			BufferedWriter log = new BufferedWriter(new FileWriter("server.log"));
			log.write("[WARNING] " + string + "\n");
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void error(String string) {
		System.out.println("[ERROR] " + string);
		try {
			BufferedWriter log = new BufferedWriter(new FileWriter("server.log"));
			log.write("[ERROR] " + string + "\n");
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void debug(String string) {
		System.out.println("[DEBUG] " +  string);
		try {
			BufferedWriter log = new BufferedWriter(new FileWriter("server.log"));
			log.write("[DEBUG] " + string + "\n");
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fatal(String string) {
		System.out.println("[FATAL] " + string);
		try {
			BufferedWriter log = new BufferedWriter(new FileWriter("server.log"));
			log.write("[FATAL] " + string + "\n");
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
}
