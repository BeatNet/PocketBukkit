package net.pocketbukkit;

import org.blockserver.Server;
import org.blockserver.ServerBuilder;
import org.blockserver.player.DummyPlayerDatabase;
import org.blockserver.ui.Log4j2ConsoleOut;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main{
    public final static String PB_VERSION = "v1.0-SNAPSHOT - (Baby Villager)";
    public final static String BUKKIT_VERSION = "1.8-R0.1-SNAPSHOT";

    public static void main(String[] args) throws UnknownHostException {
        ServerBuilder builder = new ServerBuilder();
        builder.setModulePath(new File("modules"));
        builder.setServerName("PocketBukkit");
        builder.setPlayerDatabase(new DummyPlayerDatabase());
        builder.setConsoleOut(new Log4j2ConsoleOut("PB-BlockServer"));
        builder.setIncludePath(new File("include"));
        builder.setPort(19132);
        builder.setAddress(InetAddress.getByName("localhost"));

        Server server = builder.build();
        PocketServer impl = new PocketServer(server);
        impl.getLogger().info("Hey there");
        server.start();
    }
}
