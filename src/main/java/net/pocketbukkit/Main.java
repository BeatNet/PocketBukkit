package net.pocketbukkit;

import net.pocketbukkit.bukkit.bridge.PocketServer;
import net.pocketbukkit.bukkit.plugin.BukkitPluginLoader;
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

    public static BlockServerAdapter ADAPTER;

	/**
	 * This is the unsupported level when it would lead to
	 * {@link java.lang.NullPointerException}s being thrown;
	 * frequently seen from getters that return {@code null}.
	 */
	public final static int UNSUPPORTED_LEVEL_NULL = 5;
	/**
	 * This is the unsupported level when the method returns an unexpected value,
	 * or not always the value expected (such as a placeholder value, or a similar value).
	 * Values returned by methods that
	 */
	public final static int UNSUPPORTED_LEVEL_INVALID_VALUE = 8;
	/**
	 * This is the unsupported level when the call to the function does nothing;
	 * frequently seen from empty setters.
	 */
	public final static int UNSUPPORTED_LEVEL_EMPTY_CALL = 10;
	/**
	 * This is the same as {@code UNSUPPORTED_LEVEL_EMPTY_CALL} except that the
	 * implementing API function declaration provides another way (such as returning
	 * {@code false}) to let the calling context know that the call has been rejected.
	 */
	public final static int UNSUPPORTED_LEVEL_EMPTY_CALL_ACKNOWLEDGED = 12;

	private static int levelToThrowExOnUnsupported = UNSUPPORTED_LEVEL_NULL;

	public static void main(String[] args) throws UnknownHostException{
        System.out.println("PocketBukkit, "+PB_VERSION);
		for(int i = 0; i < args.length; i++){
			String arg = args[i];
			if(arg.equalsIgnoreCase("unsupportedEx")){
				levelToThrowExOnUnsupported = parseUnsupportedLevel(args[++i]);
			}
		}
        File moduleDir = new File("modules");
        File includeDir = new File("include");
        File pluginsDir = new File("plugins");

        moduleDir.mkdirs();
        includeDir.mkdirs();
        pluginsDir.mkdirs();

		ServerBuilder builder = new ServerBuilder()
				.setModulePath(moduleDir)
				.setServerName("PocketBukkit")
				.setPlayerDatabase(new DummyPlayerDatabase())
				.setConsoleOut(new Log4j2ConsoleOut("PB-BlockServer"))
				.setIncludePath(includeDir)
				.setPort(19132)
				.setAddress(InetAddress.getByName("localhost"));
        System.out.println("Building server...");
		Server server = builder.build();

		PocketServer impl = new PocketServer(server);
        ADAPTER = new BlockServerAdapter(impl, server);
        ADAPTER.addPluginLoader(new BukkitPluginLoader(ADAPTER.getPluginManager()));
        ADAPTER.run();
	}
	public static boolean isThrowExOnUnsupported(int level){
		return level <= levelToThrowExOnUnsupported;
	}
	public static void onUnsupported(int level) throws UnsupportedOperationException{
		if(isThrowExOnUnsupported(level)){
			throw new UnsupportedOperationException();
		}
	}
	public static int parseUnsupportedLevel(String string){
		if(string.equalsIgnoreCase("null")){
			return 5;
		}
		if(string.equalsIgnoreCase("empty")){
			return 10;
		}
		return 0;
	}
}
