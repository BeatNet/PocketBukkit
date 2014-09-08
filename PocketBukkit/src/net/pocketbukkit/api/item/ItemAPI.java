/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.item;

import java.util.Map;

import org.blockserver.objects.IItem;

public class ItemAPI implements IItem {
	public int getID() {
		return 0;
	}

	public int getDamage() {
		return 0;
	}

	public int getCount() {
		return 0;
	}

	public Map<CharSequence, String> getMetadata() {
		return null;
	}
	
}
