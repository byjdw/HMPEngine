package com.dm1lk.hmprivate.commands;

import com.dm1lk.hmprivate.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GhostCommand implements CommandExecutor {
    org.bukkit.entity.Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            p = ((p = Bukkit.getPlayer(args[0])) != null) ? p : null;
            if (p != null) {
                if (p.getGameMode() != org.bukkit.GameMode.SURVIVAL) {
                    sender.sendMessage("§7§o" + p.getName() + " is already a ghost!");
                } else {
                    p.setGameMode(GameMode.ADVENTURE);
                    Bukkit.broadcastMessage("§c☠§l " + p.getName() + " fell from a high place");
                    Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
                        LuckPerms lp = LuckPermsProvider.get();
                        lp.getUserManager().modifyUser(p.getUniqueId(), user ->
                                user.data().add(Node.builder("group.dead").build()));
                    });
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
