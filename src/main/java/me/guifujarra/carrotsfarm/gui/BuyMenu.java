package me.guifujarra.carrotsfarm.gui;

import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import me.guifujarra.carrotsfarm.models.SpecialHoeBuilder;
import me.guifujarra.carrotsfarm.validations.player.PlayerBuyFirstHoe;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class BuyMenu {

    public static final String TITLE = ChatColor.GREEN + "Special Hoe";
    private static final Inventory INVENTORY = Bukkit.createInventory(null, 9, TITLE);

    static {
        fillMenu();
    }

    public static void open(Player p){
        p.openInventory(BuyMenu.INVENTORY);
    }






    private static void fillMenu(){
        ItemStack firstHoe = new SpecialHoeBuilder().setLevel(1).setCarrots(0).build();

        ItemMeta meta = firstHoe.getItemMeta();
        List<String> lore = meta.getLore();
        lore.addAll(Arrays.asList("","",ChatColor.YELLOW + "Price: " + ConfigHoe.getLevelCarrots(1)));
        meta.setLore(lore);
        firstHoe.setItemMeta(meta);

        INVENTORY.addItem(firstHoe);
    }
}
