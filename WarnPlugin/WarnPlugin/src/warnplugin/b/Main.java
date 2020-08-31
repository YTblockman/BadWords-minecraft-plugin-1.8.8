package warnplugin.b;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

import warnplugin.b.cmds.AddToKickQueue;
import warnplugin.b.cmds.Cmd;
import warnplugin.b.cmds.VoteKick;
import warnplugin.b.cmds.VoteStay;
import warnplugin.b.listener.Warn;

public class Main extends JavaPlugin{
	
	public static String developer = "YTblockman";
	public static int Players = 0;
	public static int stay;
	public static int kick;
	public static ArrayList<Player> voted = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		System.out.println("[BadWords] plugin is enabling");
		Objects.requireNonNull(getCommand("warn")).setExecutor(new Cmd());
		Objects.requireNonNull(getCommand("votekick")).setExecutor(new VoteKick());
		Objects.requireNonNull(getCommand("votestay")).setExecutor(new VoteStay());
		Objects.requireNonNull(getCommand("kickqueue")).setExecutor(new AddToKickQueue());

		getServer().getPluginManager().registerEvents(new Warn(), this);
		Kicking.resetPlayer();
	}
	
}
