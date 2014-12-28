package me.leveltest.commands;

import me.leveltest.main.LevelController;
import me.leveltest.main.LevelPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor{

	private LevelPlugin plugin;
	private LevelController lc;
	
	
	public LevelCommand(LevelPlugin p){
		plugin = p;
	
	}
	
	@Override
	public boolean onCommand(CommandSender p, Command cmd, String label, String[] args) {
		Player p1 = (Player) p;
		lc = new LevelController(plugin);
		if(args.length == 0){
			
			
			p.sendMessage("§4Dein Level: §3" + lc.getPlayerLevel(p1));
			return true;
		}else if(args.length == 1 && args[0].equalsIgnoreCase("register")){
			lc.registerPlayer(p1);
			p.sendMessage("§4Du wurdest registriert!");
			return true;
		}else if(args.length == 1 && args[0].equalsIgnoreCase("reset")){
			lc.resetPlayer(p1);
			p.sendMessage("§4Dein Account wurde resettet!");
			return true;
		}else if(args.length == 1 && args[0].equalsIgnoreCase("add")){
			p.sendMessage("§4Too few arguments!");
			return true;
		}else if(args.length == 2 && args[0].equalsIgnoreCase("add")){
			lc.addLevelToPlayer(args[1], p1);
			lc.saveFile();
			p.sendMessage("§4Es wurden " + args[1] + " geaddet!");
			
			return true;
		}else if(args.length == 2 && args[0].equalsIgnoreCase("remove")){
			lc.removeLevelToPlayer(args[1], p1);
			lc.saveFile();
			p.sendMessage("§4Es wurden " + args[1] + " removed!");
			
			return true;
		}else if(args.length == 1 && args[0].equalsIgnoreCase("check")){
			String PLevel = lc.getPlayerLevel(p1);
			int level = Integer.parseInt(PLevel);
			if(level < 5){
				p.sendMessage("§4Du bist kein Pro!");
			}else{
				p.sendMessage("§4Du bist ein Pro! Glückwunsch!");
			}
			return true;
		}else{
			p.sendMessage("WRONG!");
			return true;
		}

	}
	
}
