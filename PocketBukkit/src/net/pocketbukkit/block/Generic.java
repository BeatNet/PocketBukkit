/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.block;

public class Generic {
	public static void main(String[] args){}

	public void place(){
		//TODO: Placing Blocks
	}

	public static boolean isBreakable(boolean isBreakable){
		return isBreakable;
	}

	public void onBreak(){
		//TODO: Breaking Blocks
	}

	public void onUpdate(){
		//TODO: Block Updates
	}

	public boolean onActivate(boolean isActivable){
		return isActivable;
	}
}
