package net.pocketbukkit.api;

import java.io.File;
import java.util.ArrayList;

import org.blockserver.Server;
import org.blockserver.api.Plugin;
import org.blockserver.api.PluginManager;

public class PBPluginManager implements PluginManager {
	private Server server;

	public PBPluginManager(Server server){//, File pluginsDir){
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Plugin> getPlugins() {
		return null;
	}

	@Override
	public void loadPlugin(File file) {

	}

	@Override
	public void enablePlugin(Plugin plugin) {

	}

	@Override
	public void disablePlugin(Plugin plugin) {

	}
}
