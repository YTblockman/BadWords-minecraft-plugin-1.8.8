package warnplugin.b.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.KickStun;
import warnplugin.b.Kicking;
import warnplugin.b.Main;

public class AddToKickQueue implements CommandExecutor{
	
	private String reason = "None";
	
	@Override
	public boolean onCommand(CommandSender c, Command cmd, String label, String[] a) {
		if(!(c instanceof Player)) {
			c.sendMessage("[KickQueue] ~ Can't add player using console! Try log into game...");
		}else {
			Player sn = (Player) c;
			if(!(sn.isOp())) {
				c.sendMessage(ChatColor.RED + "I think you don't have permision to use this command!");
				c.sendMessage(ChatColor.GREEN + "Plugin by: " + ChatColor.AQUA + Main.developer);
				return false;
			}
			if(Kicking.getPlayer() != null) {
				sn.sendMessage(ChatColor.YELLOW + "Hmm... Community is alerady voting for someone...");
				return false;
			}
			try {
				try {
					reason = a[1];
				}catch(Exception e) {
					c.sendMessage(ChatColor.RED + "[BadWords] - You didn't type reason! So its setted up to None " + a[0]);
					reason = "None";
				}
				Bukkit.broadcastMessage(ChatColor.RED + "Hey, @everyone Player " + ChatColor.DARK_RED + sn.getDisplayName() + ChatColor.RED + " was added to kick queue with reason "
						+ ChatColor.AQUA + reason + ChatColor.RED + "!");
				Bukkit.broadcastMessage(ChatColor.RED + "You can vote by using /votekick or /votestay");
				Player target = (Bukkit.getServer().getPlayer(a[0]));
				Kicking.setPlayer(target);
				KickStun.wrn(target, sn, reason);
			}catch(Exception e){
				c.sendMessage(ChatColor.RED + "[KickQueue] - This player is not online, Can't find: " + a[0]);
			}
		}
		return false;
	}
}
