package me.GGGEDR.Kity.Command.Admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> tab_comple = new ArrayList<>();
        if(args.length == 1){
            tab_comple.add("give");
            tab_comple.add("set");
        }
        if(args.length == 2){
            tab_comple.add("Christmas");
            tab_comple.add("Mythic");
            tab_comple.add("Classic");
            tab_comple.add("Gangster");
        }
        if(args.length == 3){
            for(Player p: Bukkit.getOnlinePlayers()){
                tab_comple.add(p.getName());
            }
        }
        return tab_comple;
    }
}
