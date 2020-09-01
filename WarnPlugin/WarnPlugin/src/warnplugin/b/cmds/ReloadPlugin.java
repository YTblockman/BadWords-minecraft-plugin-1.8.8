package warnplugin.b.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.Kicking;
import warnplugin.b.Main;

public class ReloadPlugin implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(!(arg0 instanceof Player)) {
			arg0.sendMessage("[RELOAD] ~ RELOADING PLUGIN DATA VIA CONSOLE!");
			Main.stay = 0;
			Main.kick = 0;
			Main.voted.clear();
			Kicking.resetPlayer();
			return false;
		}
		Player s = (Player)arg0;
		if(s.isOp()) {
			Main.stay = 0;
			Main.kick = 0;
			Main.voted.clear();
			Kicking.resetPlayer();
			s.sendMessage(ChatColor.GREEN + "Sucesfully reseted plugin variables queue!");
		}else {
			s.sendMessage(ChatColor.RED + "I think you don't have permision to use this command!");
		}
		return false;
	}

}
