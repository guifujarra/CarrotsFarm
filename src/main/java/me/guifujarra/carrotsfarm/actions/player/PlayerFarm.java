package me.guifujarra.carrotsfarm.actions.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class PlayerFarm implements PlayerAction {

    @Override
    public void execute(Player p) {
        Random random = new Random();
        int i = 0;
        do {
            p.getInventory().addItem(new ItemStack(Material.CARROT_ITEM));
            i++;
        } while (i < random.nextInt(3));
    }
}
