package me.leveltest.main;

import me.leveltest.commands.LevelCommand;
import me.leveltest.listener.BlockCounter;
import me.leveltest.listener.JoinListener;

import org.bukkit.plugin.java.JavaPlugin;

public class LevelPlugin extends JavaPlugin {


	
	public void onEnable(){
		System.out.println("Level Test start");
		generateConfig();
		regEvents();
	}
	
	public void onDisable(){
		System.out.println("Level Test stop");
		
	}

	public void generateConfig(){
		this.getConfig().options().copyDefaults(false);
		this.saveConfig();	
	}
	
	public void regEvents(){
		this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		this.getServer().getPluginManager().registerEvents(new BlockCounter(this), this);
		
		this.getCommand("level").setExecutor(new LevelCommand(this));
	}

}