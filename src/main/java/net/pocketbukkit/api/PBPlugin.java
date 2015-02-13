package net.pocketbukkit.api;

import org.blockserver.Server;
import org.blockserver.api.Plugin;
import org.blockserver.ui.Logger;

import java.io.File;

/**
 * The PocketBukkit implementation of a plugin.
 */
public abstract class PBPlugin implements Plugin{
    private Server server;
    private File location;
    private String name;
    private Logger logger;
    protected boolean loaded;

    protected abstract void load();

    @Override
    public void onLoad(Server server, Logger logger) {
        this.server = server;
        this.logger = logger;
        load();
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    public String getName() { return name; }

    public Server getServer(){
        return server;
    }

    public Logger getLogger(){ return logger; }
}
