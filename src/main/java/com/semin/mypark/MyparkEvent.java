package com.semin.mypark;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class MyparkEvent implements Listener {
    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.MINECART) {
            //가장 밑에 있는 마인카트
            Minecart bottomCart = (Minecart) entity;

            entity.setVisibleByDefault(false);

            entity.setGlowing(true);

            entity.setInvulnerable(true);

            bottomCart.setMaxSpeed(5);

            //키 높이용
            Llama llama = entity.getWorld().spawn(entity.getLocation(), Llama.class, it -> {
                it.setGlowing(true);
                it.setAI(false);
                it.setInvulnerable(true);
                it.setInvisible(true);

                entity.addPassenger(it);
            });

            //허상 마인카트
            Minecart cart = entity.getWorld().spawn(entity.getLocation(), Minecart.class, it -> {
               it.setInvulnerable(true);

               llama.addPassenger(it);
            });

            BukkitTask task = new BukkitRunnable() {
                @Override
                public void run() {

                }
            }.runTaskTimer(new Mypark(), 0, 1);
        }
    }
}
