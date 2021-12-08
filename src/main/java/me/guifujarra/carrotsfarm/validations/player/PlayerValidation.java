package me.guifujarra.carrotsfarm.validations.player;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface PlayerValidation {

    void execute(InventoryClickEvent e);
}
