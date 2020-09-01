package warnplugin.b;

import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class BanStun {
	@SuppressWarnings("deprecation")
	public static void wrn(Player p, Player w, String reason) {
		System.out.println("I warned player > " + p.getDisplayName());
		p.sendTitle(ChatColor.UNDERLINE + "" + ChatColor.RED + "HEY", ChatColor.DARK_RED + "You have been added to vote ban queue! By " + w.getDisplayName());
		p.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "You have been added for " + ChatColor.AQUA + reason + ChatColor.RED + "!");
	}
}
