package me.guifujarra.carrotsfarm;

import me.guifujarra.carrotsfarm.commands.SpecialHoe;
import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import me.guifujarra.carrotsfarm.listeners.BlockBreak;
import me.guifujarra.carrotsfarm.listeners.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {


    public static Main plugin;

    @Override
    public void onEnable(){
        plugin = this;
        new ConfigHoe();
        registerCommands();
        registerListeners();
        System.out.println("CarrotsFarm is now enabled!");

    }

    private void registerCommands(){
        getCommand("specialhoe").setExecutor(new SpecialHoe());
    }

    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }


}
