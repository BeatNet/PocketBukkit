package net.pocketbukkit.module;

import net.pocketbukkit.module.resources.ModuleResources;

//import org.blockserver.Context;

public abstract class Module{ // implements Context{
	private ModuleManifest manifest;
	private boolean initialized = false;
	private boolean enabled = false;
	private ModuleAssetsManager assetsManager;
	private ModuleResources resources;
	public final void initialize(ModuleManifest manifest){
		if(initialized){
			throw new RuntimeException("Cannot initialize a Module object twice");
		}
		initialized = true;
		this.manifest = manifest;
		assetsManager = new ModuleAssetsManager(getManifest().getJar());
		resources = new ModuleResources(getManifest().getJar());
		onInit();
	}
//	@Override
	public final boolean isEnabled(){
		return enabled;
	}
	public final boolean isInitialized(){
		return initialized;
	}
	public final ModuleManifest getManifest(){
		return manifest;
	}
//	@Override
	public ModuleResources getResources(){
		return resources;
	}
	public final ModuleAssetsManager getAssetsManager(){
		return assetsManager;
	}
	public final void enable(){
		enabled = true;
		onEnable();
	}
	public final void disable(){
		enabled = false;
		onDisable();
	}
	public final void finalize(){
		onFinal();
	}
	protected void onInit(){}
	protected void onEnable(){}
	protected void onDisable(){}
	protected void onFinal(){}
	public void post(Runnable run, int ticks){
		// TODO scheduler
	}
}
