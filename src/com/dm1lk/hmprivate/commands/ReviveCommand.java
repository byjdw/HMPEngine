package com.dm1lk.hmprivate.commands;

import com.dm1lk.hmprivate.tasks.Revival;
import com.dm1lk.hmprivate.Main;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {
    Player p;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            p = ((p = Bukkit.getPlayer(args[0])) != null) ? p : null;
            if (p != null) {
                if (p.getGameMode().equals(org.bukkit.GameMode.SURVIVAL)) {
                    sender.sendMessage("§7§o" + p.getName() + " is already alive!");
                } else {
                    Revival.animation(p);
                    p.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    Bukkit.broadcastMessage("§a❤§l " + p.getName() + " has been revived!");
                    Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
                        LuckPerms lp = LuckPermsProvider.get();
                        lp.getUserManager().modifyUser(p.getUniqueId(), user ->
                                user.data().remove(Node.builder("group.dead").build()));
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
