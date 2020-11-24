package me.GGGEDR.Kity.Command.Admin;

import me.GGGEDR.Kity.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
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
            File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
            ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
            if(configurationSection != null) {
                for(String kit : configurationSection.getKeys(false)){
                    tab_comple.add(kit);
                }
            }
        }
        if(args.length == 3){
            for(Player p: Bukkit.getOnlinePlayers()){
                tab_comple.add(p.getName());
            }
        }
        return tab_comple;
    }
}
