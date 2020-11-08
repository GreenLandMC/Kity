package me.GGGEDR.Kity.Listeners;

import me.GGGEDR.Kity.Api.Configurator;
import me.GGGEDR.Kity.Api.KitsItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;

public class Click implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
            if(e.getItem() != null) {
                if (e.getItem().getItemMeta() != null) {
                    if (e.getItem().getType() == Material.PLAYER_HEAD) {
                        KitsItems kity = new KitsItems();
                        if(((SkullMeta)e.getItem().getItemMeta()).getOwner() != null) {
                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("tzehQYlx")) {
                                Configurator configurator = new Configurator("mythic");
                                configurator.activeKit(e.getPlayer());
                            }

                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("aiDe3INQ")) {
                                Configurator configurator = new Configurator("christmas");
                                configurator.activeKit(e.getPlayer());
                            }

                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("q5ImKCLN")) {
                                Configurator configurator = new Configurator("classic");
                                configurator.activeKit(e.getPlayer());
                            }

                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("3GpdlqHL")) {
                                Configurator configurator = new Configurator("gangster");
                                configurator.activeKit(e.getPlayer());
                            }

                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("JyPTvsLY")) {
                                Configurator configurator = new Configurator("shulker");
                                configurator.activeKit(e.getPlayer());
                            }

                            if (((SkullMeta) e.getItem().getItemMeta()).getOwner().equalsIgnoreCase("sr6WSoLF")) {
                                Configurator configurator = new Configurator("builder");
                                configurator.activeKit(e.getPlayer());
                            }
                        }
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

    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        for(int i = 0; i < 100; i++){
            e.getPlayer().sendMessage(" ");
        }
        if(!e.getPlayer().hasPlayedBefore()){
            e.getPlayer().getInventory().addItem(new KitsItems().getClassicHead());
            e.getPlayer().sendMessage("§a§lTeam §8» §7Keďže si na našom survivali nový rozhodli sme sa ti darovať: "+ ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit");
        }
    }
}
