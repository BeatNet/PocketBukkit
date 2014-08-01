/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Player {
	public static int nextID = 1;
	private String username;
	private String userIP;
	private int entityID;
	private int clientID;
	private int CID;
	private int port;
	
	public String getIP(){
		return this.userIP;
	}
	
	public Player(){
		
	}
	
	public InetAddress getAddress() throws UnknownHostException{
    		return InetAddress.getByName(this.userIP);
    	}
    
    	public int getPort(){
    		return this.port;
    	}
}
