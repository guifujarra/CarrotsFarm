package me.guifujarra.carrotsfarm.listeners;

import me.guifujarra.carrotsfarm.actions.hoe.ReplantCarrot;
import me.guifujarra.carrotsfarm.actions.hoe.SpecialHoeFarm;
import me.guifujarra.carrotsfarm.actions.player.PlayerFarm;
import me.guifujarra.carrotsfarm.validations.hoe.*;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockBreak implements Listener {

    private List<HoeValidation> validations = new ArrayList<>();

    public BlockBreak(){
        validations.addAll(Arrays.asList(new CarrotBroke(), new HoeInHand(), new SpecialHoe()));
    }


    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        try{
            validations.forEach(v -> v.execute(e));
        }catch (InvalidFarmException ex){
            return;
        }
        //If all validations are ok

        //Hoe action
        new ReplantCarrot().execute(e);
        //Player actions
        new PlayerFarm(e).execute(e.getPlayer());

    }
}
