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
	
	/**
	 * Creates a file with name "file" in folder "folder"<br></br>
	 * 
	 * Parameters:</br>
	 *  + folder - Folder in which to create file</br>
	 *  + file - Name of the file created (including extension)
	 */
	public static void createFile(String folder, String file) {
		File f = new File(folder + "/" + file);
		if(f.exists()) {
			if(f.isFile()) {
				return;
			} else {
				try {
					f.createNewFile();
				} catch (IOException e) {
					ServerLogger.error("There was an error while creating file " + file + " in directory " + folder + ":");
					e.printStackTrace();
				}
			}
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				ServerLogger.error("There was an error while creating file " + file + " in directory " + folder + ":");
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Creates a folder with the name of "folder"</br></br>
	 * 
	 * Parameters:</br>
	 *  + folder - Name of the folder created (Including location if needed)
	 */
	public static void createFolder(String folder) {
		File file = new File(folder);
		if(!file.exists()) {
			file.mkdir();
		} else {
			ServerLogger.error("The folder " + folder + " already exists!");
		}
	}
	
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * If true - File exists</br>
	 * If false - File does not exist</br></br>
	 * 
	 * Parameters: </br>
	 * + folder - Location of the file</br>
	 * + file - Name of the file to look for (Including extensions)
	 */
	public static boolean checkFileExists(String folder, String file) {
		File f = new File(folder + "/" + file);
		if(f.exists()) {
			if(f.isFile()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * If true - File exists</br>
	 * If false - File does not exist</br></br>
	 * 
	 * Parameters: </br>
	 *  + folder - Name of the folder to check (Including location if needed)
	 */
	public static boolean checkFolderExists(String folder) {
		File file = new File(folder);
		if(file.exists()) {
			if(file.isDirectory()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	/**
	 * Returns boolean</br></br>
	 * 
	 * If true - File exists</br>
	 * If false - File does not exist</br></br>
	 * 
	 * Parameters: </br>
	 *  + folder - Name of the folder to check (Including location if needed)
	 */
	public static boolean checkDirectoryExists(String folder) {
		File file = new File(folder);
		if(file.exists()) {
			if(file.isDirectory()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	public static void getProperty() {
		//TODO: Get YAML Property
	}
	
	public static void setProperty() {
		//TODO: Set YAML Property
	}
}
