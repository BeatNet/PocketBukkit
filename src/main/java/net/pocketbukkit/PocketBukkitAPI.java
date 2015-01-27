package net.pocketbukkit;

import org.blockserver.Server;
import org.blockserver.api.API;
import org.blockserver.net.protocol.pe.login.RaknetReceivedCustomPacket;
import org.blockserver.net.protocol.pe.login.RaknetSentCustomPacket;
import org.blockserver.player.Player;

/**
 * The PocketBukkit API
 */
public class PocketBukkitAPI implements API{
    private Server server;

    public PocketBukkitAPI(Server server){
        this.server = server;
    }

    @Override
    public boolean onPlayerJoin(Player player, Argument<String> argument) {
        return false;
    }

    @Override
    public boolean onPlayerQuit(Player player, Argument<String> argument) {
        return false;
    }

    @Override
    public boolean onDataPacketSent(Player player, Argument<RaknetSentCustomPacket.SentEncapsulatedPacket> argument) {
        return false;
    }

    @Override
    public boolean onDataPacketReceived(Player player, Argument<RaknetReceivedCustomPacket.ReceivedEncapsulatedPacket> argument, Argument<Boolean> argument1) {
        return false;
    }
}
