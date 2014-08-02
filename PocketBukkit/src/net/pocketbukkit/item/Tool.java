/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.item;

import net.pocketbukkit.Player;

public class Tool {
	public static void main(String[] args){
		boolean isPlacable = false;
		boolean isWearable = false;
		boolean isEdible = false;
		boolean isObtainable = true;
		boolean isDropable = true;
		boolean requiresOP = false;
	}

	public static void doDamage(String target, int strength) {
		Player.subtractHealth(target, strength);
	}
}
