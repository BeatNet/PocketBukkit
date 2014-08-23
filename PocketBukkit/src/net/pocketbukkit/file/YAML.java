/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import net.pocketbukkit.utility.ServerLogger;

import org.yaml.snakeyaml.Yaml;

public class YAML {
	public static final Yaml yaml = new Yaml();
	/* Parse YAML Files */
	public static void get(String YAML) {
	        yaml.load(YAML);
	}
	
	@SuppressWarnings("unchecked")
	public static String getProperty(String YAML, String option) {
		final String fileName = YAML;
	    ArrayList<String> key = new ArrayList<String>();
	    ArrayList<String> value = new ArrayList<String>();
	    String optionResult = null;
	    try {
	        InputStream fis = new FileInputStream(new File(fileName));
			Map< String, Object> result = (Map< String, Object>) yaml.load(fis);
	        for (Object name : result.keySet()) {   
	            key.add(name.toString());
	            value.add(result.get(name).toString());
	            String.valueOf(result.get(name).toString());
	        }
	    } catch (Exception e) {
	    	ServerLogger.error("A plugin called for a non-existant YAML value!");
	    }
		return optionResult; 
	}
	
	public static void setProperty(String YAML, String option) {
		
	}
}
