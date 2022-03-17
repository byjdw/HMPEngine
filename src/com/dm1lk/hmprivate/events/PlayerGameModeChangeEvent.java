package com.dm1lk.hmprivate.events;

import com.dm1lk.hmprivate.Main;
import me.libraryaddict.disguise.DisguiseAPI;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static org.bukkit.GameMode.SURVIVAL;

public class PlayerGameModeChangeEvent implements Listener {
    public PlayerGameModeChangeEvent() {
    }

    @EventHandler
    public void onPlayerGamemodeChange(org.bukkit.event.player.PlayerGameModeChangeEvent e) {
        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
            LuckPerms api = LuckPermsProvider.get();
            if (e.getNewGameMode() != SURVIVAL) {
                api.getUserManager()
                        .modifyUser(p.getUniqueId(), user -> user.data().add(Node.builder("group.dead").build()));
            } else {
                api.getUserManager()
                        .modifyUser(p.getUniqueId(), user -> user.data().remove(Node.builder("group.dead").build()));
            }
        });
        if (DisguiseAPI.isDisguised(p) && e.getNewGameMode().equals(SURVIVAL)) {
            e.getPlayer().performCommand("undis");
        }
    }
}
