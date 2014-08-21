/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.command.commands;

import net.pocketbukkit.Server;
import net.pocketbukkit.command.Command;
import net.pocketbukkit.command.Sender;

public class StopCommand extends Command {
	public static void execute() {
		if(Sender.hasPermission("pocketbukkit.server.stop")) {
			Server.stop();
		}else{
			Sender.noPermission();
		}
	}
}
