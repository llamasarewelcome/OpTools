/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

/**
 *
 * @author raffa
 */
public class PixieDust implements Listener{
    @EventHandler
    public void changeItem(PlayerItemHeldEvent e) {
        Player play = e.getPlayer();
        if (play.hasPermission("optools.tools.pixiedust")) {
            if (OpTools.hasLore(play.getInventory().getItem(e.getNewSlot()))) {
                if (OpTools.getLore(play.getInventory().getItem(e.getNewSlot())).contains("Hold it to fly!")) {
                    play.setAllowFlight(true);
                }
            } else if (OpTools.hasLore(play.getInventory().getItem(e.getPreviousSlot()))) {
                if (OpTools.getLore(play.getInventory().getItem(e.getPreviousSlot())).contains("Hold it to fly!")) {
                    play.setAllowFlight(false);
                }
            }
        }
    }
}
