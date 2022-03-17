package com.dm1lk.hmprivate.events;

import com.dm1lk.hmprivate.tasks.Revival;
import com.dm1lk.hmprivate.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static org.bukkit.GameMode.SURVIVAL;
import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;

public class PlayerInteractEvent implements Listener {
    public PlayerInteractEvent() {
    }

    @EventHandler
    public void playerInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getItem() != null && (e.getAction().equals(RIGHT_CLICK_AIR) || e.getAction().equals(RIGHT_CLICK_BLOCK)) && (e.getItem().getType().equals(Material.BOOK))) {
            ItemMeta itemMeta = e.getItem().getItemMeta();
            if (itemMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS) && itemMeta.getLore().equals(Arrays.asList("§c§lRight-click to revive yourself.", "§fCONSUMABLE")) && p.getInventory().getItemInMainHand().equals(e.getItem())) {
                if (p.getGameMode() != SURVIVAL) {
                    Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
                        if (e.getItem().getAmount() == 1) {
                            p.getInventory().setItemInMainHand(null);
                        } else {
                            e.getItem().setAmount(e.getItem().getAmount() - 1);
                        }
                    });
                    p.setGameMode(SURVIVAL);
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    Revival.animation(p);
                    Bukkit.broadcastMessage("§a❤§l " + p.getName() + " has been revived!");
                }
            }
        }
    }
}
