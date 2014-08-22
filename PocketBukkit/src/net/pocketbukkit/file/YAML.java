/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.file;

import org.yaml.snakeyaml.Yaml;

public class YAML {
	/* Get the name of a YAML File */
	public static void getYAML(String YAML) {
		Yaml yaml = new Yaml();
		yaml.getName();
	}
	
	/* Load YAML for use */
	public static void loadYAML(String YAML) {
	        Yaml yaml = new Yaml();
	        yaml.load(YAML); //This is a WIP addition and wont work yet
	}
}
