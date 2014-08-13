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
	
	public String getIP() {
		//TODO: Get Payers IP
		return null;
	}
	
	public void getName() {
		//TODO: Get player username
	}
	
	public static int getHealth() {
		return 0;
	}
	
	public static void setHealth(String target, Object finalHealth) {
		//TODO: Change health to an int
	}
	
	public void op() {
		//TODO: Add player to ops.txt
	}
	
	public void kick(String reason) {
		//TODO: Player kicking
	}
	
	public void heal(String target) {
		setHealth(target, 20);
	}
	
	public void kill(String target) {
		setHealth(target, 0);
	}
	
	public void sendMessage(String Message) {
		//TODO: Send a Message to the Player
	}
	
	public void ban(String reason) {
		//TODO: Ban player username
	}
	
	public void whitelist() {
		//TODO: Add player to whitelist.txt
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
	}
	
	public void isBanned() {
		//TODO: Check banned-players.txt
	}
	
	public void isIPBanned() {
		String IP = getIP();
		//TODO: Check banned-ips.txt for IP
	}
	public void isWhitelisted() {
		//TODO: Check whitelist.txt for Player
	}
}
