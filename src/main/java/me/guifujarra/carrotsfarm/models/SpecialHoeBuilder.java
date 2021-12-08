package me.guifujarra.carrotsfarm.models;

import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SpecialHoeBuilder {

    private Player player;
    private Material material;
    private int level;
    private List<String> lore;
    private int carrots;

    public SpecialHoeBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public SpecialHoeBuilder setLevel(int level) {
        this.level = level;
        this.carrots = ConfigHoe.getLevelCarrots(level);
        this.material = ConfigHoe.getMaterialByLevel(level);
        return this;
    }

    public SpecialHoeBuilder setCarrots(int carrots) {
        this.carrots = carrots;
        return this;
    }

    public ItemStack build() {
        if (level <= 0) {
            return null;
        }
        this.lore = ConfigHoe.getLoreByLevel(level, carrots);
        ItemStack item = new ItemStack(this.material);

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = new NBTTagCompound();
        nmsItem.setTag(tag);

        tag.setInt("currentLevel", level);
        tag.setBoolean("specialHoe", true);
        int nextLevelIn = ConfigHoe.getNextLevelCarrots(level);
        if (nextLevelIn > 0) {
            tag.setInt("nextLevelIn", nextLevelIn);
        }
        tag.setInt("carrots", carrots);

        ItemStack nbtItem = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta meta = nbtItem.getItemMeta();

        meta.setDisplayName(ConfigHoe.getNameByLevel(level));
        meta.setLore(lore);
        nbtItem.setItemMeta(meta);


        if (player != null) {
            player.sendMessage(ConfigHoe.getMessageByLevel(level));
        }

        return nbtItem;

    }
}
