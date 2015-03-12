package net.pocketbukkit;

import net.pocketbukkit.plugin.PocketPlugin;
import org.blockserver.Server;
import org.blockserver.api.API;
import org.blockserver.api.Event;
import org.blockserver.api.impl.PEDataPacketRecieveEvent;

/**
 * API class for PocketBukkit.
 */
public class PocketBukkitAPI extends API{
    private BlockServerAdapter adapter;

    public PocketBukkitAPI(Server server, BlockServerAdapter adapter){
        super(server);
        this.adapter = adapter;
    }

    @Override
    protected boolean handleEvent(Event event) {
        adapter.getLogger().debug("Handling event: "+event.getClass().getCanonicalName());
        if(event.getClass().equals(PEDataPacketRecieveEvent.class)){
            for(PocketPlugin plugin: adapter.getPluginManager().getPlugins().values()){
                return plugin.handleEvent(event);
            }
        } else {
            return false;
        }
        return false;
    }
}
