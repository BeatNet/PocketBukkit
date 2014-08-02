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

public class Food {
	public static void main(String[] args){
		boolean isPlacable = false;
		boolean isWearable = false;
		boolean isEdible = true;
		boolean isObtainable = true;
		boolean isDropable = true;
		boolean requiresOP = false;
	}

	public static void giveHealth(String target, int food){
		Player.addHealth(target, food);
	}
}
