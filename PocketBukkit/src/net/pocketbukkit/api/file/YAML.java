/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.file;

import java.io.*;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YAML {
	/**
	 * Reads a YAML file</br></br>
	 * 
	 * Parameters:</br>
	 *  + file - File to read
	 */
	@SuppressWarnings("unchecked")
	public static void readYAML(String file) {
		Yaml yaml = new Yaml();
		try {
			InputStream ios = new FileInputStream(new File(file));
         
			Map<String,Object> result = (Map<String,Object>)yaml.load(ios);
			returnStatement(result.toString());   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Returns data</br></br>
	 * 
	 * Parameters:</br>
	 *  + data - Data to return
	 */
	private static String returnStatement(String data) {
		return data;
	}
}