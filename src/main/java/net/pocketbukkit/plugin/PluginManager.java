package net.pocketbukkit.plugin;

import net.pocketbukkit.BlockServerAdapter;
import org.blockserver.Server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PluginManager{
	private Server server;
    private org.bukkit.Server bukkitServer;
    private BlockServerAdapter adapter;
	private ArrayList<PluginLoader> loaders = new ArrayList<>();
	private HashMap<String, PocketPlugin> pluginMap = new HashMap<>();
	public PluginManager(Server server, BlockServerAdapter adapter){
		this.server = server;
        this.adapter = adapter;
        this.bukkitServer = adapter.getBukkitServer();
	}
	public void registerPluginLoader(PluginLoader loader){
		loaders.add(loader);
	}
	public void registerPluginLoader(PluginLoader loader, int index){
		loaders.add(index, loader);
	}
	/**
	 * Register a {@link PluginLoader} before another one.
	 * @param loader the loader to register
	 * @param before the class of the loader to register before.
	 * @return whether {@code before} is registered
	 */
	public boolean registerPluginLoaderBefore(PluginLoader loader, Class<? extends PluginLoader> before){
		int index = loaders.size();
		boolean changed = false;
		for(int i = 0; i < loaders.size(); i++){
			if(loaders.get(i).getClass().equals(before)){
				index = i;
				changed = true;
				break;
			}
		}
		registerPluginLoader(loader, index);
		return changed;
	}
	public void loadPlugins(File dir) throws IOException{
        adapter.getLogger().info("Loading Plugins...");
		if(!dir.isDirectory()){
			throw new IllegalArgumentException("File passed is not a directory");
		}
		File[] files = dir.listFiles();
        System.out.println(Arrays.toString(files));
		if(files == null){
			throw new IOException("Failed to list files in passed File");
		}
		for(File file: files){
            System.out.println("Loop: " + file.getName());
			for(PluginLoader loader: loaders) {
                if (loader.acceptsPlugin(file)) {
                    PocketPlugin plugin = loader.loadPlugin(file);
                    pluginMap.put(plugin.getName(), plugin);
                    break;
                } else {
                    adapter.getLogger().warning("Plugin rejected: " + file.getName());
                }
            }
		}
        System.out.println("load complete.");
        adapter.getLogger().info("Load complete.");
	}
	public ArrayList<PluginLoader> getPluginLoaders(){
		return loaders;
	}
	public Server getServer(){
		return server;
	}
    public org.bukkit.Server getBukkitServer(){ return bukkitServer; }
    public BlockServerAdapter getBlockServerAdapter(){ return adapter; }
	public HashMap<String, PocketPlugin> getPlugins(){
		return pluginMap;
	}
}
