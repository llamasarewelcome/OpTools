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
package com.raphaellevy.optools.command;

import com.raphaellevy.optools.OpTools;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author raffa
 */
public class GetOpTools implements Listener{
    
    public static void run(CommandSender cs, Command cmnd, String string, String[] strings) {
        Player play = (Player) cs;
        play.openInventory(OpTools.getInstance().i);
    }
    
    @EventHandler
    public void onInv(InventoryClickEvent e) {
        if (e.getInventory().getName().equals("Op Tools")) {
            e.setCancelled(true);
            ItemStack i = e.getCurrentItem();
            if (i != null) {
                if (i.getType() != Material.AIR) {
                    if (e.getClickedInventory().getName().equals("Op Tools")) {
                        e.getWhoClicked().getInventory().addItem(new ItemStack(i));
                    }
                }
            }
        }
    }
    @EventHandler
    public void onMove(InventoryMoveItemEvent e) {
        if (e.getDestination().getName().equals("Op Tools")) {
            e.setCancelled(true);
        }
    }
}
