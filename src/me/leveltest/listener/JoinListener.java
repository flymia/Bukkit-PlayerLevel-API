package me.leveltest.listener;

import me.leveltest.main.LevelController;
import me.leveltest.main.LevelPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	LevelPlugin plugin;
	LevelController lc;
	
	public JoinListener(LevelPlugin p){
		this.plugin = p;
		lc = new LevelController(p);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player eP = e.getPlayer();
		if(!e.getPlayer().hasPlayedBefore()){
			LevelController lc = new LevelController(plugin);
			lc.registerPlayer(eP);
			eP.sendMessage("§4Du bist nun registriert!");
		}
		
		eP.sendMessage("§4Willkommen! Dein Level: " + lc.getPlayerLevel(eP));
		
	}
	
}
