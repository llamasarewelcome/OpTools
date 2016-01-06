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

import static com.raphaellevy.optools.OpTools.getLore;
import static com.raphaellevy.optools.OpTools.hasLore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
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
    @EventHandler
    public void drop(PlayerDropItemEvent e) {
        if (hasLore(e.getItemDrop().getItemStack())) {
            if (getLore(e.getItemDrop().getItemStack()).contains("Hold it to fly!")) {
                e.getPlayer().setAllowFlight(false);
            }
        }
    }
}
