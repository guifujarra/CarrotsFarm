package me.guifujarra.carrotsfarm.actions.hoe;

import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface HoeAction {


    void execute(BlockBreakEvent e);


    default ItemStack updateLore(net.minecraft.server.v1_8_R3.ItemStack nmsItem, int level, int carrots){
        ItemStack item = CraftItemStack.asBukkitCopy(nmsItem);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(ConfigHoe.getLoreByLevel(level, carrots));
        item.setItemMeta(itemMeta);
        return item;
    }
}
