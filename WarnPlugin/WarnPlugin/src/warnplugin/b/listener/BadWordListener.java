package warnplugin.b.listener;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import net.md_5.bungee.api.ChatColor;
import warnplugin.b.Main;

@SuppressWarnings("deprecation")
public class BadWordListener implements Listener{
	private Player s;
	private static String msg;
	private static ArrayList<String> b = ListOfBadWords.BadWordsConfig();
	private static float times;
	@EventHandler
	public void onMessage(PlayerChatEvent a) {
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
				if(Main.badwords.containsKey(s)) {
					times = Main.badwords.get(s);
					if(times >= 2) {
						s.kickPlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "YOU WERE KICKED!\n" + ChatColor.RESET + "" + ChatColor.RED + "Please don't scream this bad words! :(");
						Main.badwords.remove(s);
					}else {
						Main.badwords.replace(s, times+1);
						s.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "HEY! Don't scream that bad words... There are only " + ChatColor.YELLOW + Math.round(3 - (Main.badwords.get(s))) +
								ChatColor.RED + " new chances!");
					}
				}else {
					Main.badwords.put(s, (float) 0.0);
					s.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "HEY! Don't scream that bad words... There are only " + ChatColor.YELLOW + Math.round(3 - (Main.badwords.get(s))) +
							ChatColor.RED + " new chances!");	
				}
			}
		}
	}
	
	public static String getPlrMsg() {
		return msg;
	}
	
}
