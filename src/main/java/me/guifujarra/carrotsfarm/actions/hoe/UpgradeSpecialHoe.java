package me.guifujarra.carrotsfarm.actions.hoe;

import me.guifujarra.carrotsfarm.models.SpecialHoeBuilder;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class UpgradeSpecialHoe implements HoeAction {


    public void execute(BlockBreakEvent e){
        Player p = e.getPlayer();

        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(e.getPlayer().getItemInHand());
        NBTTagCompound tag = nmsItem.getTag();

        int newLevel = tag.getInt("currentLevel") + 1;

        p.setItemInHand(new SpecialHoeBuilder().setPlayer(p).setLevel(newLevel).build());


    }
}
