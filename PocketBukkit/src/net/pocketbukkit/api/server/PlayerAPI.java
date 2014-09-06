/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.server;

import org.blockserver.Server;
import org.blockserver.item.Inventory;
import org.blockserver.player.Player;

public class PlayerAPI extends Player {

	public PlayerAPI(Server server, String ip, int port, short mtu, long clientID) {
		super(server, ip, port, mtu, clientID);
	}
	
	public static void sendChat(String message) {
		Player.sendMessage(message);
	}
	
	public static String getName() {
		return Player.getName();
	}
	
	public static void kick() {
		String reason = "Kicked from server!";
		Player.close(reason);
	}
	
	public static void kick(String reason) {
		Player.close(reason);
	}
	
	public static Inventory getInventory() {
		return Player.getInventory();
	}
}
