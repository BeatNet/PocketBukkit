/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api.inventory;

import java.util.Iterator;

import org.blockserver.objects.IInventory;
import org.blockserver.objects.IItem;

@SuppressWarnings("rawtypes")
public class InventoryAPI implements IInventory {
	public Iterator iterator() {
		return null;
	}

	public int getSize() {
		return 0;
	}

	public IItem[] getItems() {
		return null;
	}

}
