package net.pocketbukkit;

import net.pocketbukkit.api.Information;
import net.pocketbukkit.api.PBPluginManager;
import org.blockserver.Server;
import org.blockserver.ServerBuilder;
import org.blockserver.player.DummyPlayerDatabase;
import org.blockserver.ui.Log4j2ConsoleOut;

import java.io.File;

public class PocketBukkit {

    public static void main(String[] args){
        ServerBuilder builder = new ServerBuilder();
        //TODO: Actually load this stuff.
        builder.setServerName("Hi");
        builder.setPort(19132);
        File includePath = new File("data");
        includePath.mkdirs();
        builder.setIncludePath(includePath);
        builder.setConsoleOut(new Log4j2ConsoleOut());
        builder.setPlayerDatabase(new DummyPlayerDatabase());

        System.out.println(Information.API + ", " + Information.API_DESCRIPTION);
        System.out.println("Version "+Information.VERSION+"(V "+Information.VERSION_CODE+") Name: "+Information.CODE_NAME);
        System.out.println("Starting server...");

        Server server = builder.build();
        server.setAPI(new PocketBukkitAPI(server, new PBPluginManager(server)));

        server.start();
    }
}
