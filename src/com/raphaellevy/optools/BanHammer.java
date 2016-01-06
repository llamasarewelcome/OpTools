/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author raffa
 */
public class BanHammer implements Listener{
    @EventHandler
    public void kill(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player play = (Player) e.getDamager();
            if (OpTools.hasLore(play.getItemInHand()) && play.hasPermission("optools.tools.banhammer")) {
                if (OpTools.getLore(play.getItemInHand()).contains("Hit players to ban them")) {
                    if (e.getEntity() instanceof Player) {
                        ((Player)e.getEntity()).setBanned(true);
                        ((Player)e.getEntity()).kickPlayer("FEAR THE BAN HAMMER");
                    }
                }
            }
        }
    }
}
