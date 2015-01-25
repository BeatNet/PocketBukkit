package net.pocketbukkit.addon;

public class AddonApiVersion{
	private int edition = -1;
	private int version = -1;
	private int revision = -1;
	public AddonApiVersion(String str) throws NumberFormatException{
		String[] splited = str.split("\\.");
		if(splited.length != 3){
			throw new IllegalArgumentException("API version must be the format {edition}.{version}.{revision}");
		}
		edition = Integer.parseInt(splited[0]);
		version = Integer.parseInt(splited[1]);
		revision = Integer.parseInt(splited[2]);
		if(edition < 0 || version < 0 || revision < 0){
			throw new NumberFormatException("API versions should not be negative");
		}
	}
}
