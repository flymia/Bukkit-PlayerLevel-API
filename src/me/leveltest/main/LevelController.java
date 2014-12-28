package me.leveltest.main;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class LevelController {

	LevelPlugin plugin;
	
	private Player _p;
	private String _level;

	private FileConfiguration cfg = null;
	private File levels = null;
	
	public LevelController(LevelPlugin plugin){
		this.plugin = plugin;
		if(levels == null){
			levels = new File("plugins/LevelTest" + File.separator + "levels.yml");
		}
		cfg = YamlConfiguration.loadConfiguration(levels);
		cfg.options().copyDefaults(false);
	}
	
	public String getPath(Player p){
		String path = p.getDisplayName()+ ".level";
		return path;
	}
	
	public void registerPlayer(Player p){
		cfg.set(p.getDisplayName()+ ".level", 1);
		try {
			cfg.save(levels);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

	public String getPlayerLevel(Player p){
		
		String path = cfg.getString(p.getDisplayName() + ".level");
		if(path == null){
			cfg.set(p.getDisplayName()+ ".level", 1);
			try {
				cfg.save(levels);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		return path;
	}
	
	public void addLevelToPlayer(String howmuch, Player p){
		String path = cfg.getString(p.getDisplayName() + ".level");
		int level = Integer.parseInt(path);
		int addhow = Integer.parseInt(howmuch);
		level +=  addhow;
		Integer levelFinal = new Integer(level);
		cfg.set(p.getDisplayName()+ ".level", level);
		try {
			cfg.save(levels);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
	public void removeLevelToPlayer(String howmuch, Player p){
		String path = cfg.getString(p.getDisplayName() + ".level");
		int level = Integer.parseInt(path);
		int addhow = Integer.parseInt(howmuch);
		level -=  addhow;
		Integer levelFinal = new Integer(level);
		cfg.set(p.getDisplayName()+ ".level", level);
		try {
			cfg.save(levels);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public void saveFile(){
		try {
			cfg.save(levels);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	public void resetPlayer(Player p){
		cfg.set(getPath(p), 1);
		try {
			cfg.save(levels);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
