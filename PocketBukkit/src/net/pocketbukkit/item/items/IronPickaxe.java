/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.item.items;

import net.pocketbukkit.item.Item;
import net.pocketbukkit.item.Tool;

public class IronPickaxe extends Tool implements Item {
	public static final String target = null;
	public static final int strength = 2;

	public static void main(String[] args){
		Tool.doDamage(target, strength);
	}
}
