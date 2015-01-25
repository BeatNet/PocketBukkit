/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.api;

public interface Information{
	/**
	 * Returns API Software
	 */
	public static final String API = "PocketBukkit";
	
	/**
	 * Returns API Software Description
	 */
	public static final String API_DESCRIPTION = "The Minecraft PE Server API";
	
	/**
	 * Returns API Version (As a String)
	 */
	public static final String VERSION = "1.0.0";
	
	/**
	 * Returns API Version (As an Integer)
	 */
	public static final int VERSION_CODE = 1;
	
	/**
	 * Returns API Codename
	 */
	public static final String CODE_NAME = "Baby Villager";
}
