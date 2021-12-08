package me.guifujarra.carrotsfarm.validations.hoe;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

public class CarrotBroke implements HoeValidation {


    @Override
    public void execute(BlockBreakEvent e) {
        Block block = e.getBlock();
        Material material = block.getType();

        if (!material.equals(Material.CARROT)|| block.getData() < (byte) 5) {
            throw new InvalidFarmException("Just carrots can be farmed");
        }
    }
}
