package me.guifujarra.carrotsfarm.actions.player;

import me.guifujarra.carrotsfarm.actions.hoe.SpecialHoeFarm;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class PlayerFarm implements PlayerAction {

    private BlockBreakEvent event;

    public PlayerFarm(BlockBreakEvent event){
        this.event = event;
    }

    @Override
    public void execute(Player p) {
        Random random = new Random();
        int i = 0;
        do {
            new SpecialHoeFarm().execute(event);
            p.getInventory().addItem(new ItemStack(Material.CARROT_ITEM));
            i++;
        } while (i < random.nextInt(3));
    }
}
