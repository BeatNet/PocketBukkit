/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.utility;

import net.pocketbukkit.format.Color;

public class ServerLogger{
	public void info(String string) {
		System.out.println(Color.FORMAT_GREEN + System.currentTimeMillis() + "[INFO] " + Color.FORMAT_RESET + string);
	}
	public void warning(String string) {
		System.out.println(Color.FORMAT_YELLOW + System.currentTimeMillis() + "[WARNING] " + Color.FORMAT_RESET + string);
	}
	public void error(String string) {
		System.out.println(Color.FORMAT_RED + System.currentTimeMillis() + "[ERROR] " + Color.FORMAT_RESET + string);
	}
	public void debug(String string) {
		System.out.println(Color.FORMAT_CYAN + System.currentTimeMillis() + "[DEBUG] " + Color.FORMAT_RESET + string);
	}
	public void fatal(String string) {
		System.out.println(Color.FORMAT_RED + System.currentTimeMillis() + "[FATAL] " + string);
		System.exit(1);
	}
}
