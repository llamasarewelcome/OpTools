/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
