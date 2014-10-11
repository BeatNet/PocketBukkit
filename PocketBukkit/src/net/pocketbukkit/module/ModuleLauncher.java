package net.pocketbukkit.module;

import java.io.File;

import net.pocketbukkit.module.chat.ModuleChatManager;

import org.blockserver.Server;
import org.blockserver.chat.ChatManager;
import org.blockserver.level.generator.GenerationSettings;
import org.blockserver.player.BSFPlayerDatabase;
import org.blockserver.player.PlayerDatabase;
import org.blockserver.utility.MinecraftVersion;

public class ModuleLauncher{
	public static Server server;
	public static void main(String[] main) throws Exception{
		String name = "BlockServer using ModuleAPI";
		String ip = "0.0.0.0";
		short port = (short) 19132;
		int maxPlayers = 10;
		MinecraftVersion version = MinecraftVersion.V095;
		String defaultLevel = "level";
		GenerationSettings genSet = null;
		Class<? extends ChatManager> chatMgrType = ModuleChatManager.class;
		Class<? extends PlayerDatabase> dbType = BSFPlayerDatabase.class;
		File here = new File(".");
		File worlds = new File(here, "worlds");
		File players = new File(here, "players");
//		server = new Server(name, ip, port, maxPlayers, version, defaultLevel,
//				genSet, chatMgrType, dbType, worlds, players);
		// these two lines have been commented out since currently it is very possible that the constructor changes.
	}
}
