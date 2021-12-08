package me.guifujarra.carrotsfarm.configs;

import me.guifujarra.carrotsfarm.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigHoe {

    private static File configFileHoes;
    private static YamlConfiguration configHoes;

    public ConfigHoe(){
        saveHoes();
    }


    private void saveHoes() {
        configFileHoes = new File(Main.plugin.getDataFolder(), "hoes.yml");
        if (!configFileHoes.exists()) {
            Main.plugin.saveResource("hoes.yml", false);
        }
        configHoes = YamlConfiguration.loadConfiguration(configFileHoes);
        try {
            configHoes.save(configFileHoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getNameByLevel(Integer level){
        String dir = getDirByLevel(level);
        return configHoes.getString(dir + ".name").replace('&', ChatColor.COLOR_CHAR);
    }

    public static List<String> getLoreByLevel(Integer level, Integer carrots){
        List<String> lore = new ArrayList<>();
        String dir = getDirByLevel(level);
        configHoes.getStringList(dir + ".lore").forEach(s ->{
            lore.add(s.replace("{amount}", carrots.toString()).replace('&', ChatColor.COLOR_CHAR));
        });
        return lore;
    }

    public static int getLevelCarrots(Integer level){
        String dir = getDirByLevel(level);
        return configHoes.getInt(dir + ".carrots");
    }

    public static int getNextLevelCarrots(Integer currentLevel){
        String dir = getDirByLevel(currentLevel + 1);
        return configHoes.getInt(dir + ".carrots");
    }

    public static Material getMaterialByLevel(Integer level){
        String dir = getDirByLevel(level);
        return Material.getMaterial(configHoes.getString(dir + ".material") + "_HOE");
    }

    public static String getMessageByLevel(Integer level){
        String dir = getDirByLevel(level);
        return configHoes.getString(dir + ".message").replace('&', ChatColor.COLOR_CHAR);
    }


    private static String getDirByLevel(Integer level){
        return level + ".";
    }
}
