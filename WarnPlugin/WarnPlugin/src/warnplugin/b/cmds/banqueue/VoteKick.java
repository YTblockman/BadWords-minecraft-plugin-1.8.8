package warnplugin.b.cmds.banqueue;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.CheckSum;
import warnplugin.b.Kicking;
import warnplugin.b.Main;

public class VoteKick implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender c, Command cmd, String label, String[] a) {
		if(!(c instanceof Player)) {
			c.sendMessage("[KickQueue] ~ Console can't vote!");
		}else {
			if(Kicking.getPlayer() == null) {
				c.sendMessage(ChatColor.YELLOW + "Hmm... There is nothing to vote for...");
				return false;
			}
			Player plr = (Player) c;
			if(!Main.voted.contains(plr)) {
				Main.kick ++;
				plr.sendMessage(ChatColor.GREEN + "Your vote has been submited!");
				Main.voted.add(plr);
			}else {
				plr.sendMessage(ChatColor.RED + "You've alerady voted!");
			}
			for (@SuppressWarnings("unused") Player player : Bukkit.getServer().getOnlinePlayers()) {
		        Main.Players++;
		    }
			if(Main.voted.size() > Main.Players /3) {
				if(CheckSum.check()) {
					if(Main.ban) {
						Bukkit.broadcastMessage(ChatColor.RED + Kicking.getPlayer().getDisplayName() + " had family, but... BANG, Ban apeared!!!");
						Kicking.getPlayer().kickPlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "YOU HAVE BEEN BANNED\n" + ChatColor.RESET + ""
								+ ChatColor.RED + "community voted!\n" + "please contact our personal on discord to clear your ban!");
						Main.banned.add(Kicking.getPlayer().getDisplayName());
					}else {
						Bukkit.broadcastMessage(ChatColor.RED + Kicking.getPlayer().getDisplayName() + " had family, but... KICK!");
						Kicking.getPlayer().kickPlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "YOU HAVE BEEN KICKED!\n" + ChatColor.RESET + "" + ChatColor.RED + "Community voted you for leave!");
					
					}
				}else {
					Bukkit.broadcastMessage(ChatColor.GREEN + Kicking.getPlayer().getDisplayName() + ChatColor.GREEN + " is lucky today!!!");
					Kicking.getPlayer().sendMessage(ChatColor.GREEN + "You're free, community voted for you to stay");// do not kick
				}
				Main.stay = 0;
				Main.kick = 0;
				Main.voted.clear();
				Kicking.resetPlayer();
			}
		}
		return false;
	}

}
