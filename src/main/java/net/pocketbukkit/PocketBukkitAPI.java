package net.pocketbukkit;

import org.blockserver.Server;
import org.blockserver.api.API;
import org.blockserver.api.Event;

/**
 * API class for PocketBukkit.
 */
public class PocketBukkitAPI extends API{

    public PocketBukkitAPI(Server server) {
        super(server);
    }

    @Override
    protected boolean handleEvent(Event event) {
        return false;
    }
}
