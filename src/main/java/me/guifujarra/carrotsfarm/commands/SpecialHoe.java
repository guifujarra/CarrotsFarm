package me.guifujarra.carrotsfarm.commands;

import me.guifujarra.carrotsfarm.gui.BuyMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecialHoe implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("specialhoe")) {
            if (sender instanceof Player p) {
                BuyMenu.open(p);
                return true;
            }
            sender.sendMessage("Just players can send this command.");

        }
        return false;
    }
}
