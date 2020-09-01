package warnplugin.b.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.Main;

public class PlayerJoinEventCheckSum implements Listener{
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
		Player p = e.getPlayer();
		if(Main.banned.contains(p.getDisplayName())) {
			p.kickPlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "YOU HAVE BEEN BANNED\n" + ChatColor.RESET + ""
					+ ChatColor.RED + "community voted!\n" + "please contact our personal on discord to clear your ban!");
		}
    }
   
}
