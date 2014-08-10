/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit;

public class Player {
	public static int nextID = 1;
	
	public void getIP() {
		//TODO: Get Payers IP
	}
	
	public void getName() {
		//TODO: Get player username
	}
	
	public void getHealth() {
		//TODO: Get players health
	}
	
	public void setHealth() {
		//TODO: Change health to an int
	}
	
	public void op() {
		//TODO: Add player to ops.txt
	}
	
	public void kick() {
		//TODO: Player kicking
	}
	
	public void kill() {
		//TODO: Killing Player
	}
	
	public void ban() {
		//TODO: Ban player username
	}
	
	public void banIP() {
		String IP = getIP();
		//TODO: Ban player IP
	}
	
	public void deOp() {
		//TODO: Reove player from ops.txt
	}
	
	public void unBan() {
		//TODO: Unban player username
	}
	
	public void unBanIP() {
		//TODO: Unban player IP
	}
	
	public void isOp() {
		//TODO: Check ops.txt
		return boolean;
	}
	
	public void isBanned() {
		//TODO: Check banned-players.txt
		return boolean;
	}
	
	public void isIPBanned() {
		String IP = getIP();
		//TODO: Check banned-ips.txt for IP
		return boolean;
	}
	public void isWhitelisted() {
		//TODO: Check whitelist.txt for Player
		return boolean;
	}
}
