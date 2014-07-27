/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import net.pocketbukkit.utility.ServerLogger;
import net.pocketbukkit.Server;

public class TCPSocket {
	public ServerLogger logger = new ServerLogger();
	
	public static void openTCPPort() throws IOException {
		 ServerSocket PocketBukkitTCP = new ServerSocket(19132);
		 while(Server.serverRunning)
         {
			 Socket PocketBukkitSocket = PocketBukkitTCP.accept();
			 try {
				 if(Server.serverRunning) {
				 }
				 else {
					 PocketBukkitTCP.close();
					 PocketBukkitSocket.close();
					 break;
				 }
			 }
			 finally {
			 }
         }
	 }
	
	public void closeTCPPort() throws IOException {
		ServerSocket PocketBukkitTCP = new ServerSocket(19132);
		PocketBukkitTCP.close();
	}
	
}
