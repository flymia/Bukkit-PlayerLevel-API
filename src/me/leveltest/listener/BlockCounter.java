package me.leveltest.listener;

import me.leveltest.main.LevelController;
import me.leveltest.main.LevelPlugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockCounter implements Listener{

	LevelPlugin plugin;
	LevelController lc;
	private int _howmanyTimes;
	
	public BlockCounter(LevelPlugin p){
		this.plugin = p;
		lc = new LevelController(p);
	}
	
	@EventHandler
	public void onBlockPlace(BlockBreakEvent e){
		Block b = e.getBlock();
		Player p = e.getPlayer();
		
		if(b.getType().equals(Material.STONE)){
			p.sendMessage("§3Du hast einen Steinblock abgebaut!");
			_howmanyTimes++;
			
			if(_howmanyTimes == 5){
				lc.addLevelToPlayer("1", p);
				p.sendMessage("§4Du bist im Level aufgestiegen! Level 1 Miner Level: " + lc.getPlayerLevel(p));
			}else if(_howmanyTimes == 10){
				lc.addLevelToPlayer("1", p);
				p.sendMessage("§4Du bist im Level aufgestiegen! Level 2 Miner Level: " + lc.getPlayerLevel(p));
			}
		}
		
		p.sendMessage("Block abgebaut!");
	}
	
}
