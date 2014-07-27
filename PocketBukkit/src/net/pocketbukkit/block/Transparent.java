/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.block;

public class Transparent extends Generic{
	public static void main(String[] args){
		boolean isActivable = false;
		boolean breakable = true;
		boolean isFlowable = false;
		boolean isTransparent = true;
		boolean isReplaceable = false;
		boolean isPlaceable = true;
		boolean isSolid = true;
	}

	public static boolean isBreakable(boolean breakable){
		Generic.isBreakable(breakable);
		return breakable;
	}
}
