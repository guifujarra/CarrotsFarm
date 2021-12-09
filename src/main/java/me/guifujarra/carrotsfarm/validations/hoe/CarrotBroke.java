package me.guifujarra.carrotsfarm.validations.hoe;

import me.guifujarra.carrotsfarm.actions.hoe.ReplantCarrot;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

public class CarrotBroke implements HoeValidation {


    @Override
    public void execute(BlockBreakEvent e) {
        Block block = e.getBlock();
        Material material = block.getType();

        if (!material.equals(Material.CARROT)) {
            throw new InvalidFarmException("Just carrots can be farmed");
        }
        if(block.getData() < (byte) 5){
            new ReplantCarrot().execute(e);
            throw new InvalidFarmException("Too early to break");
        }
    }
}
