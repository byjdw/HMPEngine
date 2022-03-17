package com.dm1lk.hmprivate.commands;

import com.dm1lk.hmprivate.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ReviveBookCommand implements CommandExecutor {
    Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            p = ((p = Bukkit.getPlayer(args[0])) != null) ? p : null;
            if (p != null) {
                Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
                    ItemStack item = new ItemStack(Material.BOOK);

                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName("§c❤§4§l The Revive Book §c❤");
                    itemMeta.setLore(Arrays.asList("§c§lRight-click to revive yourself.", "§fCONSUMABLE"));
                    itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item.setItemMeta(itemMeta);

                    p.getInventory().addItem(item);
                    sender.sendMessage("§7§o A revive book was given to " + p.getName() + "!");
                    p.sendMessage("§c❤§l You're received a revive book!");
                });
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
