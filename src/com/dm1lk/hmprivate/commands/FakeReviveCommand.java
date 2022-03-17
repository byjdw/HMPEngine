package com.dm1lk.hmprivate.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FakeReviveCommand implements CommandExecutor {
    org.bukkit.entity.Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            p = ((p = Bukkit.getPlayer(args[0])) != null) ? p : null;
            if (p != null) {
                Bukkit.broadcastMessage("§a❤§l " + p.getName() + " has been revived!");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
