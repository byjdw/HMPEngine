package com.dm1lk.hmprivate.tasks;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Revival {
    public static void animation(Player p) {
        World world = (World) p.getWorld();
        Location location = (Location) p.getLocation();
        Firework fw = (Firework) world.spawnEntity(location.add(0, 1, 0), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.setPower(0);
        fwm.addEffects(FireworkEffect.builder().withColor(Color.LIME).flicker(true).withFade(Color.AQUA, Color.GRAY, Color.WHITE).build(),
                FireworkEffect.builder().withColor(Color.AQUA).flicker(true).withFade(Color.GRAY, Color.WHITE, Color.LIME).build(),
                FireworkEffect.builder().withColor(Color.GRAY).flicker(true).withFade(Color.WHITE, Color.LIME, Color.AQUA).build(),
                FireworkEffect.builder().withColor(Color.WHITE).flicker(true).withFade(Color.LIME, Color.AQUA, Color.WHITE).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
        world.playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1000000, 1);
        world.strikeLightningEffect(p.getLocation());
        p.setFireTicks(0);
        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30, 255));
    }
}
