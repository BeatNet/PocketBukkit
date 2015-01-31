package net.pocketbukkit;

import net.pocketbukkit.api.Information;
import net.pocketbukkit.api.PBPluginManager;
import org.blockserver.Server;
import org.blockserver.ServerBuilder;
import org.blockserver.player.DummyPlayerDatabase;
import org.blockserver.ui.Log4j2ConsoleOut;
import org.yaml.snakeyaml.Yaml;
import sun.rmi.runtime.Log;

import javax.sound.midi.MidiDevice;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PocketBukkit implements Runnable{
    private Log4j2ConsoleOut logger;
    private Log4j2ConsoleOut serverLogger;

    private String includePath;
    private String serverName;
    private int serverPort;

    private PocketBukkitAPI api;
    protected Server server;

    public static void main(String[] args){
        PocketBukkit pb = new PocketBukkit();
        pb.run();
    }

    public void run(){
        logger = new Log4j2ConsoleOut("PocketBukkit");
        serverLogger = new Log4j2ConsoleOut("PB-BlockServer");
        logger.info(Information.API + ", "+Information.API_DESCRIPTION);
        logger.info(Information.VERSION+" (v"+Information.VERSION_CODE+" ["+Information.CODE_NAME+"])");

        try {
            loadData();
        } catch (IOException e) {
            logger.fatal("Failed to load data!");
            logger.trace("IOException: "+e.getMessage());
            System.exit(1);
        }
        api = new PocketBukkitAPI(this, new PBPluginManager(this));

        ServerBuilder builder = new ServerBuilder();
        builder.setServerName(serverName);
        builder.setPort(serverPort);

        File includePath = new File(this.includePath);
        includePath.mkdirs();

        builder.setIncludePath(includePath);
        builder.setPlayerDatabase(new DummyPlayerDatabase());
        builder.setConsoleOut(serverLogger);

        logger.info("Starting server...");
        server = builder.build();
        server.start();
    }

    private void loadData() throws IOException {
        logger.info("Loading data...");
        File configFile = new File("pocketbukkit.yml");
        if(!configFile.exists()){
            logger.info("Did not find pocketbukkit.yml, generating new file.");
            generateNewConfig(configFile);
        }
        Yaml yml = new Yaml();
        Map map = (Map) yml.load(new FileInputStream(configFile));

        serverName = (String) map.get("ServerName");
        if(map.get("ServerPort") instanceof String){
            serverPort = Integer.parseInt((String) map.get("ServerPort"));
        } else {
            serverPort = (Integer) map.get("ServerPort");
        }

        includePath = (String) map.get("IncludePath");

        logger.info("Loaded data!");

    }

    private void generateNewConfig(File file) throws IOException {
        /*
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("ServerName", Information.API + " - " + Information.API_DESCRIPTION);
        data.put("ServerPort", 19132);
        data.put("IncludePath", "data");

        Yaml yml = new Yaml();

        String toWrite = yml.dump(data);
        */
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("ServerName: "+Information.API+" - "+Information.API_DESCRIPTION+"\n");
        writer.write("ServerPort: 19132\n");
        writer.write("IncludePath: data\n");
        writer.close();
    }
}
