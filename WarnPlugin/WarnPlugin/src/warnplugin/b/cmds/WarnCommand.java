package warnplugin.b.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.WarnStun;

public class WarnCommand implements CommandExecutor{

	private String reason;
	
	@Override
	public boolean onCommand(CommandSender c, Command cmd, String s, String[] a) {
		if(!(c instanceof Player)) {
			c.sendMessage("[BadWords] ~ Can't warn player using console! Try log into game...");
		}else {
			if(!(c.isOp())) {
				return false;
			}
			try {
				Player target = (Bukkit.getServer().getPlayer(a[0]));
				Player sn = (Player) c;
				try {
					reason = a[1];
					WarnStun.wrn(target, sn, reason);
				}catch(Exception e) {
					c.sendMessage(ChatColor.RED + "[BadWords] - You didn't type reason!" + a[0]);
					reason = "None";
				}
			}catch(Exception e){
				c.sendMessage(ChatColor.RED + "[BadWords] - This player is not online, Can't find: " + a[0]);
			}
		}
		return false;
	}

}
