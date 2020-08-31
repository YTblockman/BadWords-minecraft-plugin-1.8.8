package warnplugin.b;

import org.bukkit.entity.Player;

public class Kicking {

	private static Player plr;
	
	public static void setPlayer(Player pl) {
		plr = pl;
	}
	
	public static Player getPlayer() {
		return plr;
	}
	
	public static void resetPlayer() {
		plr = null;
	}
	
}
