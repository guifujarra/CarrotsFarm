package me.guifujarra.carrotsfarm.validations.player;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClicked implements PlayerValidation{


    @Override
    public void execute(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();
        if(item == null || item.getType() == Material.AIR){
            throw new InvalidPlayerFarmException("Invalid item clicked");
        }
        e.setCancelled(true);

    }
}
