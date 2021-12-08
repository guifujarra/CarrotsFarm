package me.guifujarra.carrotsfarm.actions.hoe;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SpecialHoeFarm implements HoeAction {



    @Override
    public void execute(BlockBreakEvent e){

        ItemStack item = e.getPlayer().getItemInHand();

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound tag = nmsItem.getTag();
        int level = tag.getInt("currentLevel");
        int currentCarrots = tag.getInt("carrots");
        int newCarrots = currentCarrots + 1;
        tag.setInt("carrots", newCarrots);
        if(isUpgradable(nmsItem)){
            new UpgradeSpecialHoe().execute(e);
            return;
        }

        e.getPlayer().setItemInHand(updateLore(nmsItem, level, newCarrots));

    }

    private static boolean isUpgradable(net.minecraft.server.v1_8_R3.ItemStack item){
        NBTTagCompound tag = item.getTag();
        int actualCarrots = tag.getInt("carrots");
        int nextLevel = tag.getInt("nextLevelIn");
        return actualCarrots >= nextLevel && nextLevel > 0;
    }
}
