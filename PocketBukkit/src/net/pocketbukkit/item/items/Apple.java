/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.item.items;

import net.pocketbukkit.item.Food;
import net.pocketbukkit.item.Item;

public class Apple extends Food implements Item {
	public static final String target = null;
	public static final int food = 1;

	public static void main(String[] args){
		Food.giveHealth(target, food);
	}
}
