package net.pocketbukkit.bukkit.plugin;

import net.pocketbukkit.plugin.PocketPlugin;
import org.blockserver.api.Event;
import org.bukkit.plugin.Plugin;

public abstract class BukkitPlugin implements PocketPlugin{
	private Plugin plugin;

	@Override
	public String getName(){
		return plugin.getName();
	}

    public abstract boolean handleEvent(Event evt);

}
