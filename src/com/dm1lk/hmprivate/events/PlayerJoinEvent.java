package com.dm1lk.hmprivate.events;

import com.dm1lk.hmprivate.tasks.Revival;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    public PlayerJoinEvent() {
    }

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            e.setJoinMessage("§a❤§l " + p.getName() + " has been summoned by the revive machine!");
            Revival.animation(p);
        }
    }
}
