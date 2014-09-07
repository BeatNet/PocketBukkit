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
import org.blockserver.player.Player;

public class ServerAPI {
		public static Server server;
		
		public ServerAPI() {
			try {
				server = new Server(null, null, (short) 0, 0, null, null, null, null, null, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static String getServerIP() {
			return server.getServerIP();
		}
		
		public static String getServerName() {
			return server.getServerName();
		}
		
		public static String getServerVersion() {
			return server.getVersion();
		}
		
		public static int getServerPort() {
			return server.getServerPort();
		}
		
		public static Player getPlayer(String ip) {
			return server.getPlayer(ip, 0);
		}
		
		public static Player getPlayer(String ip, int port) {
			return server.getPlayer(ip, port);
		}
		
		public static int getOnlinePlayers() {
			return server.getPlayersConnected();
		}
		
		public static int getMaxPlayers() {
			return server.getMaxPlayers();
		}
}
