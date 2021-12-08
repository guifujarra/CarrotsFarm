package me.guifujarra.carrotsfarm.validations.player;

import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBuyFirstHoe implements PlayerValidation {
    private static final int FIRST_HOE_PRICE = ConfigHoe.getLevelCarrots(1);


    @Override
    public void execute(InventoryClickEvent e) {
        int carrots = 0;
        Player p = (Player) e.getWhoClicked();
        for (ItemStack i : p.getInventory()) {
            if(i == null || i.getType() == Material.AIR){
                continue;
            }
            if (i.getType() == Material.CARROT_ITEM) {
                carrots += i.getAmount();
            }
        }

        if(carrots < FIRST_HOE_PRICE){
            p.sendMessage(ChatColor.RED +  "Sorry, you don't have enough carrots to buy this hoe.");
            p.closeInventory();
            throw new InvalidPlayerFarmException("Not enough carrots in inventory");
        }


    }
}
