package me.guifujarra.carrotsfarm.validations.hoe;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


public class SpecialHoe implements HoeValidation {


    @Override
    public void execute(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInHand();
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = nmsItem.getTag();
        if(tag == null || !tag.getBoolean("specialHoe")){
            System.out.println("Not a special hoe");
            throw new InvalidFarmException("Item in hand must be a special hoe");
        }

    }

}
