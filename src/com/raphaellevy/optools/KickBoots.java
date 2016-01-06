/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author raffa
 */
public class KickBoots implements Listener{
    @EventHandler
    public void kill(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player play = (Player) e.getDamager();
            if (OpTools.hasLore(play.getItemInHand()) && play.hasPermission("optools.tools.kickboots")) {
                if (OpTools.getLore(play.getItemInHand()).contains("Hit players to kick them")) {
                    if (e.getEntity() instanceof Player) {
                        ((Player) e.getEntity()).kickPlayer(play.getName()+ " kicked you using his boots!");
                    }
                }
            }
        }
    }
}
