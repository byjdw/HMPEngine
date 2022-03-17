package com.dm1lk.hmprivate.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static org.bukkit.GameMode.ADVENTURE;
import static org.bukkit.GameMode.SURVIVAL;

public class PlayerDeathEvent implements Listener {
    public PlayerDeathEvent() {
    }

    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        if (e.getEntity().getPlayer().getGameMode() == SURVIVAL) {
            e.getEntity().getPlayer().setGameMode(ADVENTURE);
            Bukkit.broadcastMessage("§c☠§l " + e.getDeathMessage());
        } else {
            Bukkit.broadcastMessage("§7☠§l " + e.getDeathMessage());
        }
        e.setDeathMessage(null);
    }
}
