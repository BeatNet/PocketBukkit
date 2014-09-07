/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.logger;

//import net.pocketbukkit.format.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServerLogger{
	public static Calendar cal = Calendar.getInstance();
	public static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public static void info(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
	
	public static void debug(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
	
	public static void warning(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
	
	public static void warn(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
	
	public static void error(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
	
	public static void fatal(String message) {
		System.out.println(sdf.format(cal.getTime()) + " [INFO] " + message);
	}
}
