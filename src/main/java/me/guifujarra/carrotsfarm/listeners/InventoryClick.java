package me.guifujarra.carrotsfarm.listeners;

import me.guifujarra.carrotsfarm.actions.player.PlayerBuySpecialHoe;
import me.guifujarra.carrotsfarm.validations.hoe.InvalidFarmException;
import me.guifujarra.carrotsfarm.validations.player.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryClick implements Listener {

    private List<PlayerValidation> validations = new ArrayList<>();

    public InventoryClick(){
        validations.addAll(Arrays.asList(new BuyMenuClicked(), new ItemClicked(), new PlayerBuyFirstHoe()));
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e){
        try{
            validations.forEach(v -> v.execute(e));
        }catch (InvalidPlayerFarmException ex){
            return;
        }
        new PlayerBuySpecialHoe().execute((Player) e.getWhoClicked());
    }

}
