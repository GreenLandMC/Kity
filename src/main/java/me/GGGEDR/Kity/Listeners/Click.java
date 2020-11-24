package me.GGGEDR.Kity.Listeners;

import me.GGGEDR.Kity.Api.Configurator;
import me.GGGEDR.Kity.Api.KitsItems;
import me.GGGEDR.Kity.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Click implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
            if(e.getItem() != null) {
                if (e.getItem().getItemMeta() != null) {
                    if (e.getItem().getType() == Material.PLAYER_HEAD) {
                        if(((SkullMeta)e.getItem().getItemMeta()).getOwner() != null) {
                            File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
                            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                            ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
                            List<String> codes = new ArrayList<>();
                            HashMap<String, String> code_kit = new HashMap<>();
                            for(String kit : configurationSection.getKeys(false)){
                                String code = yamlConfiguration.getString("kits."+ kit +".code");
                                codes.add(code);
                                code_kit.put(code, kit);
                            }
                            if (codes.contains(((SkullMeta) e.getItem().getItemMeta()).getOwner())) {
                                Configurator configurator = new Configurator(code_kit.get(((SkullMeta) e.getItem().getItemMeta()).getOwner()));
                                configurator.activeKit(e.getPlayer());
                            }
                        }
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.PLAYER_HEAD) {
            e.setCancelled(true);
        }
    }
}
