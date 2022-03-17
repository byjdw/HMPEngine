package com.dm1lk.hmprivate;

import com.dm1lk.hmprivate.commands.*;
import com.dm1lk.hmprivate.events.PlayerDeathEvent;
import com.dm1lk.hmprivate.events.PlayerGameModeChangeEvent;
import com.dm1lk.hmprivate.events.PlayerInteractEvent;
import com.dm1lk.hmprivate.events.PlayerJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Plugin plugin;
    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        PluginManager PluginManager = this.getServer().getPluginManager();
        this.getCommand("revive").setExecutor(new ReviveCommand());
        this.getCommand("ghost").setExecutor(new GhostCommand());
        this.getCommand("fakerevive").setExecutor(new FakeReviveCommand());
        this.getCommand("fakeghost").setExecutor(new FakeGhostCommand());
        this.getCommand("revivebook").setExecutor(new ReviveBookCommand());
        PluginManager.registerEvents(new PlayerDeathEvent(), this);
        PluginManager.registerEvents(new PlayerGameModeChangeEvent(), this);
        PluginManager.registerEvents(new PlayerJoinEvent(), this);
        PluginManager.registerEvents(new PlayerInteractEvent(), this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Goodbye cruel world...");
    }
}
