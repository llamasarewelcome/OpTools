/* 
 * Copyright (C) 2016 Raphael Levy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
