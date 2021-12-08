package me.guifujarra.carrotsfarm.validations.hoe;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class HoeInHand implements HoeValidation{

    private List<Material> hoes;

    public HoeInHand(){
        fillHoes();
    }

    @Override
    public void execute(BlockBreakEvent e) {
        Material material = e.getPlayer().getItemInHand().getType();
        if(!hoes.contains(material)){
            throw new InvalidFarmException("Item in hand must be a hoe");
        }

    }

    private void fillHoes(){
        hoes = new ArrayList<>();
        hoes.add(Material.WOOD_HOE);
        hoes.add(Material.STONE_HOE);
        hoes.add(Material.IRON_HOE);
        hoes.add(Material.GOLD_HOE);
        hoes.add(Material.DIAMOND_HOE);
    }
}
