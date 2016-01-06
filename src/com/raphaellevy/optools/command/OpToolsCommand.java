/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphaellevy.optools.command;

import com.raphaellevy.optools.OpTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Represents all commands starting with /optools
 * @author raffa
 */
public class OpToolsCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        //Give version
        if (strings.length == 0) {
            OpToolsCommand.giveVersion(cs);
        }
        //if there are arguments
        if (strings.length > 0) {
            switch (strings[0]) {
                case "version":
                    giveVersion(cs);
                    break;
                case "get":
                    if (cs instanceof Player) {
                        if (cs.hasPermission("optools.get")) {
                            cs.sendMessage("Getting OpTools");
                            GetOpTools.run(cs, cmnd, string, strings);
                        } else {
                            OpTools.P(cs);
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
    
    static void giveVersion(CommandSender cs) {
        if (cs instanceof Player) {
            if (cs.hasPermission("optools.version")) {
                cs.sendMessage("Running OpTools version 1");
            } else {
                OpTools.P(cs);
            }
        } else {
            cs.sendMessage("Running OpTools version 1");
        }
    }

    
}
