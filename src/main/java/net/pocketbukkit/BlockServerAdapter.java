package net.pocketbukkit;

import net.pocketbukkit.bukkit.plugin.BukkitPluginLoader;
import net.pocketbukkit.plugin.PluginLoader;
import net.pocketbukkit.plugin.PluginManager;
import org.blockserver.Server;
import org.blockserver.ui.Log4j2ConsoleOut;
import org.blockserver.ui.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class BlockServerAdapter implements Runnable{
    private Server server;
    private Logger logger;
    private ArrayList<PluginLoader> loaders = new ArrayList<PluginLoader>();
    private org.bukkit.Server bukkitServer;

    private PluginManager pluginMgr;
    private PocketBukkitAPI api;

    public BlockServerAdapter(org.bukkit.Server bukkitServer, Server blockserver){
        this.bukkitServer = bukkitServer;
        server = blockserver;
        pluginMgr = new net.pocketbukkit.plugin.PluginManager(server, this);

        Log4j2ConsoleOut out = new Log4j2ConsoleOut("BlockServer-Adapter");
        logger = new Logger(out);
    }

    @Override
    public void run() {
        logger.info("Adding plugin loaders...");
        for(PluginLoader loader: loaders){
            logger.info("Adding "+loader.getClass().getCanonicalName());
            pluginMgr.registerPluginLoader(loader);
        }
        /*
        try {
            pluginMgr.loadPlugins(new File("plugins"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        api = new PocketBukkitAPI(server, this);
        server.setAPI(api);

        logger.info("Starting server...");
        server.start();
    }

    /**
     * Add a plugin loader to be added to the manager. This will only work before run() is called.
     * @param loader The plugin loader.
     */
    public void addPluginLoader(PluginLoader loader){
        loaders.add(loader);
    }

    public Server getServer(){
        return server;
    }

    public org.bukkit.Server getBukkitServer(){
        return bukkitServer;
    }

    public Logger getLogger(){
        return logger;
    }

    public PluginManager getPluginManager() {
        return pluginMgr;
    }
}
