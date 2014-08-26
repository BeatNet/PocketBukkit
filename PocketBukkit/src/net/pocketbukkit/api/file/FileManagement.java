/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.file;

import java.io.File;
import java.io.IOException;

import net.pocketbukkit.api.logger.ServerLogger;

public class FileManagement {
	public static void createFile(String Folder, String File) {
		File file = new File(Folder + "/" + File);
		if(file.exists()) {
			if(file.isFile()) {
				return;
			} else {
				try {
					file.createNewFile();
				} catch (IOException e) {
					ServerLogger.error("There was an error while creating file " + File + " in directory " + Folder + ":");
					e.printStackTrace();
				}
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				ServerLogger.error("There was an error while creating file " + File + " in directory " + Folder + ":");
				e.printStackTrace();
			}
		}
	}
	
	public static void createFolder(String Folder) {
		File file = new File(Folder);
		if(!file.exists()) {
			file.mkdir();
		} else {
			ServerLogger.error("The folder " + Folder + " already exists!");
		}
	}
	
	public static boolean checkFileExists(String Folder, String File) {
		File file = new File(Folder + "/" + File);
		if(file.exists()) {
			if(file.isFile()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public static boolean checkFolderExists(String Folder) {
		File file = new File(Folder);
		if(file.exists()) {
			if(file.isDirectory()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public static boolean checkDirectoryExists(String Folder) {
		File file = new File(Folder);
		if(file.exists()) {
			if(file.isDirectory()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
}
