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
