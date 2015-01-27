package net.pocketbukkit.api;

import org.blockserver.Server;
import org.blockserver.api.Plugin;

import java.io.File;

/**
 * The PocketBukkit implementation of a plugin.
 */
public abstract class PBPlugin implements Plugin{
    private Server server;
    private File location;
    private String name;
    private boolean loaded;

    @Override
    public void onLoad(Server server) {
        this.server = server;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }
}
