/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools;

import com.raphaellevy.optools.command.GetOpTools;
import com.raphaellevy.optools.command.OpToolsCommand;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class.
 * 
 * @author raffa
 */
public class OpTools extends JavaPlugin{
    /**
     * The plugin version
     */
    private static final String VERSION = "0.3";
    
    private static OpTools instance;
    
    public static OpTools getInstance() {
        return OpTools.instance;
    }
    
    public static void P(CommandSender p) {
        p.sendMessage("You do not have permission to do that.");
    }
    
    /**
     * Get the current version of OpTools
     * @return The current version of this plugin
     */
    public static String getVersion() {
        return VERSION;
    }
    
    public Inventory i;
    
    @Override
    public void onEnable() {
        OpTools.instance = this;
        
        //Inform the console that OpTools is emabled
        Bukkit.getLogger().log(Level.INFO, "OpTools is now enabled!");
        
        //Register commands
        this.getCommand("optools").setExecutor(new OpToolsCommand());
        
        //Register Events
        Bukkit.getServer().getPluginManager().registerEvents(new GetOpTools(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KillSword(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KickBoots(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Detonator(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BanHammer(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PixieDust(), this);
        
        //Set up menu
        i = Bukkit.createInventory(null, 9, "Op Tools");
        i.addItem(getItemStackWithLoreAndName(Material.STONE_PICKAXE, "Ban Hammer", "Hit players to ban them"));
        i.addItem(getItemStackWithLoreAndName(Material.IRON_BOOTS, "KickBoots", "Hit players to kick them"));
        i.addItem(getItemStackWithLoreAndName(Material.DIAMOND_SWORD, "KillSword", "OHKO!!!"));
        i.addItem(getItemStackWithLoreAndName(Material.FIREBALL, "Detonator", "Kick Everybody!"));
        i.addItem(getItemStackWithLoreAndName(Material.GLOWSTONE_DUST, "Pixie Dust", "Hold it to fly!"));
    }
    public static ItemStack getItemStackWithLore(Material m, int amount, String name, String... lore) {
        ItemStack is = new ItemStack(m,amount);
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        if (name != null) {
            im.setDisplayName(name);
        }
        is.setItemMeta(im);
        return is;
    }
    public static ItemStack getItemStackWithLore(Material m, String... lore) {
        return OpTools.getItemStackWithLore(m,1,null,lore);
    }
    public static ItemStack getItemStackWithLoreAndName(Material m, String name, String... lore) {
        return OpTools.getItemStackWithLore(m, 1, name, lore);
    }
    public static boolean hasLore(ItemStack i) {
        if (i != null) {
            if (i.hasItemMeta()) {
                if (i.getItemMeta().hasLore()) {
                    return true;
                }
            }
        }
        return false;
    }
    public static List<String> getLore(ItemStack i) {
        return i.getItemMeta().getLore();
    }
}
