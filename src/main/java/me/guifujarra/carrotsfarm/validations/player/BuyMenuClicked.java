package me.guifujarra.carrotsfarm.validations.player;

import me.guifujarra.carrotsfarm.gui.BuyMenu;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BuyMenuClicked implements PlayerValidation{

    @Override
    public void execute(InventoryClickEvent e) {
        if(e.getClickedInventory() == null || !e.getClickedInventory().getTitle().equals(BuyMenu.TITLE)){
            throw new InvalidPlayerFarmException("The menu clicked is not the Buy Menu");
        }

    }
}
