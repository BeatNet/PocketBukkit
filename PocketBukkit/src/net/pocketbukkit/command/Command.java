/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import net.pocketbukkit.utility.ServerLogger;

public class Command {
	private static ServerLogger logger;
	public static String Command;
	public static boolean RequireOP = false;
	static BufferedReader ops;
	
	public static void onCommand(){
		if(RequireOP){
			try {
				ops = new BufferedReader(new FileReader("ops.txt"));
				try {
					ops.readLine();
				} catch (IOException e) {
					Sender.sendMessage("You do not have permission to do that.");
				}
			} catch (FileNotFoundException e) {
				logger.fatal("Unable to find the ops.txt file!");
			}
		}
	}
}
