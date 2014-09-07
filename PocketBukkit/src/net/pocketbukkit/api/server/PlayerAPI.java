/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.server;

import org.blockserver.item.Inventory;
import org.blockserver.player.Player;

public class PlayerAPI {
	
	public static Player player = new Player(null, null, 0, (short) 0, 0);
	
	public static void sendChat(String message) {
		player.sendMessage(message);
	}
	
	public static String getName() {
		return player.getName();
	}
	
	public static void kick() {
		String reason = "Kicked from server!";
		player.close(reason);
	}
	
	public static void kick(String reason) {
		player.close(reason);
	}
	
	public static Inventory getInventory() {
		return player.getInventory();
	}
}
