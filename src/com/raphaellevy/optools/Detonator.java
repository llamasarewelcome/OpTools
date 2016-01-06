/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author raffa
 */
public class Detonator implements Listener{
    @EventHandler
    public void onInt(PlayerInteractEvent e) {
        if (e.getPlayer().hasPermission("optools.tools.detonator")) {
            if (OpTools.hasLore(e.getPlayer().getItemInHand())) {
                if (OpTools.getLore(e.getPlayer().getItemInHand()).contains("Kick Everybody!")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.kickPlayer("BOOM!!!");
                    }
                }
            }
        }
    }
}
