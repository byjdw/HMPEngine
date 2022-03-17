package com.dm1lk.hmprivate.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FakeGhostCommand implements CommandExecutor {
    org.bukkit.entity.Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            p = ((p = Bukkit.getPlayer(args[0])) != null) ? p : null;
            if (p != null) {
                Bukkit.broadcastMessage("§c☠§l " + p.getName() + " fell from a high place");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
