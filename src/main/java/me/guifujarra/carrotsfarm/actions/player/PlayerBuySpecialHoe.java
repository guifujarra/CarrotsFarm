package me.guifujarra.carrotsfarm.actions.player;

import me.guifujarra.carrotsfarm.configs.ConfigHoe;
import me.guifujarra.carrotsfarm.models.SpecialHoeBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class PlayerBuySpecialHoe implements PlayerAction {


    @Override
    public void execute(Player p) {
        removeCarrotsFromInventory(p);
        p.getInventory().addItem(new SpecialHoeBuilder().setPlayer(p).setLevel(1).setCarrots(0).build());
        p.closeInventory();

    }

    private void removeCarrotsFromInventory(Player p) {
        int removed = 0;
        for (ItemStack item : p.getInventory()) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }
            if (item.getType() != Material.CARROT_ITEM) {
                continue;
            }

            int amount = item.getAmount();
            for (int i = 0; i < amount; i++) {
                if (item.getAmount() == 1) {
                    p.getInventory().remove(item);
                }else {
                    item.setAmount(item.getAmount() - 1);
                }
                removed++;
                if (removed == ConfigHoe.getLevelCarrots(1)) {
                    return;
                }
            }
        }
    }
}
