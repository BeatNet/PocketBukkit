package net.pocketbukkit.module;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.pocketbukkit.module.resources.ModuleResources;

import org.blockserver.Context;
import org.blockserver.Server;

public abstract class Module implements Context{
	private Server server;
	private ModuleManifest manifest;
	private boolean initialized = false;
	private boolean enabled = false;
	private ModuleAssetsManager assetsManager;
	private ModuleResources resources;

	private List<Runnable> runnableQueue = new ArrayList<Runnable>();
	private Map<Long, List<Runnable>> postQueue = new HashMap<Long, List<Runnable>>(0);

	public final void initialize(ModuleManifest manifest, Server server){
		if(initialized){
			throw new RuntimeException("Cannot initialize a Module object twice");
		}
		initialized = true;
		this.manifest = manifest;
		this.server = server;
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
	public Server getServer(){
		return server;
	}
	//	@Override
	public final ModuleResources getResources(){
		return resources;
	}
	public final ModuleAssetsManager getAssetsManager(){
		return assetsManager;
	}
	public File getDir(){
		File file = new File(server.getPluginsDir(), getManifest().getName());
		file.mkdirs();
		return file;
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
		onFinalize();
	}
	protected void onInit(){}
	protected void onEnable(){}
	protected void onDisable(){}
	protected void onFinalize(){}

	/**
	 * <p>A thread-safe method for querying operations.
	 * The delay is undefined, but it is run before the next call of <code>onTick()</code>.</p>
	 * @param run
	 */
	public void runOnMainThread(Runnable run){
		runnableQueue.add(run);
	}
	public void post(Runnable run, int delay){
		Long ticks = server.getScheduler().getCurrentTick() + delay;
		if(!postQueue.containsKey(ticks)){
			postQueue.put(ticks, new ArrayList<Runnable>(1));
		}
		postQueue.get(ticks).add(run);
	}
	public void tick(){
		while(runnableQueue.size() > 0){
			runnableQueue.remove(0).run();
		}
		Long current = server.getScheduler().getCurrentTick();
		List<Runnable> list = postQueue.remove(current);
		if(list != null){
			for(Runnable runnable: list){
				runnable.run();
			}
		}
		onTick();
	}
	protected void onTick(){}
}
