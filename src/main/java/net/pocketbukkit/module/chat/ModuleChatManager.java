package net.pocketbukkit.module.chat;

import org.blockserver.Server;
import org.blockserver.chat.ChatManager;
import org.blockserver.player.Player;

public class ModuleChatManager extends ChatManager{
	private Server server;
	@Override
	public Server getServer(){
		return server;
	}

	@Override
	protected void handlePlayerChat(Player player, String msg){
		// TODO Auto-generated method stub
	}

	@Override
	protected void broadcastMsg(String string){
		// TODO Auto-generated method stub
	}

	@Override
	public void initialize(Server server){
		this.server = server;
	}
}
