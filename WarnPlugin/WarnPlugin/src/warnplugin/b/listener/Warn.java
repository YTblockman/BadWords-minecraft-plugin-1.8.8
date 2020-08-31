package warnplugin.b.listener;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class Warn implements Listener{
	private Player s;
	private static String msg;
	private static ArrayList<String> b = ListOfBadWords.BadWordsConfig();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMessage(AsyncPlayerChatEvent a) {
		s = a.getPlayer();
		msg = a.getMessage();
		msg = msg.toLowerCase();
		for(int i = 0; i < b.size(); i++) {
			String badWord = b.get(i);
			if(msg.contains(b.get(i).toLowerCase())) {
				msg.replaceAll(badWord, "!BadWord!");
				a.setCancelled(true);
				System.out.println("I warned player > " + s.getDisplayName());
				s.sendTitle(ChatColor.UNDERLINE + "" + ChatColor.RED + "HEY", ChatColor.BLUE + "Don't scream that bad words!");
				s.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "HEY! Don't scream that bad words...");	
			}
		}
	}
	
	public static String getPlrMsg() {
		return msg;
	}
	
}
