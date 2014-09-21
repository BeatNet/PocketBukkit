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
				server = Server.getInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Returns Server IP
		 */
		public static String getServerIP() {
			return server.getServerIP();
		}
		
		/**
		 * Returns Server Name
		 */
		public static String getServerName() {
			return server.getServerName();
		}
		
		/**
		 * Returns Server Version
		 */
		public static String getServerVersion() {
			return server.getVersion();
		}
		
		/**
		 * Returns Server Port
		 */
		public static int getServerPort() {
			return server.getServerPort();
		}
		
		/**
		 * Returns Player</br></br>
		 * 
		 * Parameters:</br>
		 *  + ip - Players IP
		 */
		public static Player getPlayer(String ip) {
			return server.getPlayer(ip, 0);
		}
		
		/**
		 * Returns Player</br></br>
		 * 
		 * Parameters:</br>
		 *  + ip - Players IP</br>
		 *  + port - Players Port
		 */
		public static Player getPlayer(String ip, int port) {
			return server.getPlayer(ip, port);
		}
		
		/**
		 * Returns Online Players
		 */
		public static int getOnlinePlayers() {
			return server.getPlayersConnected();
		}
		
		/**
		 * Returns Max Players
		 */
		public static int getMaxPlayers() {
			return server.getMaxPlayers();
		}
}
