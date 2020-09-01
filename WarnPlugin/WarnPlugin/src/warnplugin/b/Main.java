package warnplugin.b;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import warnplugin.b.cmds.AddToKickQueue;
import warnplugin.b.cmds.ReloadPlugin;
import warnplugin.b.cmds.WarnCommand;
import warnplugin.b.cmds.banqueue.AddToBanQueue;
import warnplugin.b.cmds.VoteKick;
import warnplugin.b.cmds.VoteStay;
import warnplugin.b.listener.BadWordListener;
import warnplugin.b.listener.PlayerJoinEventCheckSum;

public class Main extends JavaPlugin{
	
	public static String developer = "YTblockman";
	public static boolean ban;
	public static int Players = 0;
	public static int stay;
	public static int kick;
	public static ArrayList<Player> voted = new ArrayList<Player>();
	public static ArrayList<String> banned = new ArrayList<String>();
	public static HashMap<Player, Float> badwords = new HashMap<Player, Float>();
	@Override
	public void onEnable() {
		System.out.println("[BadWords] plugin is enabling");
		Objects.requireNonNull(getCommand("warn")).setExecutor(new WarnCommand());
		Objects.requireNonNull(getCommand("votekick")).setExecutor(new VoteKick());
		Objects.requireNonNull(getCommand("votestay")).setExecutor(new VoteStay());
		Objects.requireNonNull(getCommand("kickqueue")).setExecutor(new AddToKickQueue());
		Objects.requireNonNull(getCommand("bdrl")).setExecutor(new ReloadPlugin());
		
		Objects.requireNonNull(getCommand("banqueue")).setExecutor(new AddToBanQueue());
		getServer().getPluginManager().registerEvents(new BadWordListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinEventCheckSum(), this);
		Kicking.resetPlayer();
	}
	
}
