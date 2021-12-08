package me.guifujarra.carrotsfarm.actions.hoe;

import me.guifujarra.carrotsfarm.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

public class ReplantCarrot implements HoeAction{

    @Override
    public void execute(BlockBreakEvent e) {
        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
            e.getBlock().setType(Material.CARROT);
        }, 2L);
    }
}
