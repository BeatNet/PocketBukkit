package net.pocketbukkit;

import net.pocketbukkit.api.PBPluginManager;
import org.blockserver.Server;
import org.blockserver.api.API;
import org.blockserver.api.PluginManager;
import org.blockserver.net.protocol.pe.login.RaknetReceivedCustomPacket;
import org.blockserver.net.protocol.pe.login.RaknetSentCustomPacket;
import org.blockserver.player.Player;

/**
 * The PocketBukkit API
 */
public class PocketBukkitAPI implements API{
    private Server server;
    private PBPluginManager manager;

    public PocketBukkitAPI(Server server, PBPluginManager manager){
        this.server = server;
        this.manager = manager;
    }

    @Override
    public boolean onPlayerJoin(Player player, Argument<String> argument) {
        return true;
    }

    @Override
    public boolean onPlayerQuit(Player player, Argument<String> argument) {
        return true;
    }

    @Override
    public boolean onDataPacketSent(Player player, Argument<RaknetSentCustomPacket.SentEncapsulatedPacket> argument) {
        return true;
    }

    @Override
    public boolean onDataPacketReceived(Player player, Argument<RaknetReceivedCustomPacket.ReceivedEncapsulatedPacket> argument, Argument<Boolean> argument1) {
        return true;
    }

    public PluginManager getPluginManager(){
        return manager;
    }

    public Server getServer(){
        return server;
    }
}
