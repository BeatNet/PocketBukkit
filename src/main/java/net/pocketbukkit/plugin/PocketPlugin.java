package net.pocketbukkit.plugin;

import org.blockserver.api.Event;

public interface PocketPlugin{
	public String getName();
    public boolean handleEvent(Event evt);
}
