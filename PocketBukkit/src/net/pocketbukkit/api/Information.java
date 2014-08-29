package net.pocketbukkit.api;

public class Information {
	public static final String API = "PocketBukkit";
	public static final String APIDescription = "The Minecraft PE Server API";
	public static final String Version = "1.0.0";
	public static final int VersionINT = 100;
	public static final String CodeName = "Baby Villager";
	
	public static String getAPIName() {
		return API;
	}
	
	public static String getAPIDescription() {
		return APIDescription;
	}
	
	public static String getAPI() {
		return Version;
	}
	
	public static String getAPIString() {
		return Version;
	}
	
	public static int getAPIInt() {
		return VersionINT;
	}
	
	public static String getCodeName() {
		return CodeName;
	}
}
