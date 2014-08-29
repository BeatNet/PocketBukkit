package net.pocketbukkit.module;

import java.io.InputStream;
import java.util.jar.JarFile;

import org.blockserver.Context;

public class Module implements Context{
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
		resources = new ModuleResources(getManifest().getJar()); // TODO modifiers
	}
	@Override
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
	final InputStream getResourceFile(String name){
		JarFile jar = getManifest().getJar();
		try{
			return jar.getInputStream(jar.getJarEntry("res/" + name));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public final ModuleAssetsManager getAssetsManager(){
		return assetsManager;
	}
}
