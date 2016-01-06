/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import static com.raphaellevy.optools.OpTools.P;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author raffa
 */
public class KillSword implements Listener{
    @EventHandler
    public void kill(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player play = (Player) e.getDamager();
            if (play.hasPermission("optools.tools.killsword")) {
                if (OpTools.hasLore(play.getItemInHand())) {
                    if (OpTools.getLore(play.getItemInHand()).contains("OHKO!!!")) {
                        if (e.getEntity() instanceof LivingEntity) {
                            ((LivingEntity) e.getEntity()).setHealth(0);
                        }
                    }
                }
            }
        }
    }
}
