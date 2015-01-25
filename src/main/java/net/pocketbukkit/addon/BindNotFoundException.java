package net.pocketbukkit.addon;

public class BindNotFoundException extends Exception{
	private static final long serialVersionUID = 0;
	private Addon addon;
	public BindNotFoundException(Addon addon){
		super("Addon binds to " + addon.getBind() + " but it is not loaded yet");
		this.addon = addon;
	}
	public Addon getFailingAddon(){
		return addon;
	}
}
