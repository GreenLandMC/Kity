package me.GGGEDR.Kity.Listeners;

import me.GGGEDR.Kity.Api.KitsItems;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class FirstJoin implements Listener {

    @EventHandler
    public void onFirstJoinAndReceiveClassicKit(PlayerLoginEvent e){
        if(!e.getPlayer().hasPlayedBefore()){
            KitsItems kity = new KitsItems();
            e.getPlayer().getInventory().addItem(kity.getKitHead("classic"));
        }
    }

}
