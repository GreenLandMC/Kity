package me.GGGEDR.Kity.Api;

import me.GGGEDR.Kity.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KitsItems {

    public ItemStack getKitHead(String name){
        FileConfiguration config = Main.getInstance().getConfig();
        Head head = new Head(applyColor(config.getString("kits."+ name +".name")), config.getString("kits."+ name +".texture"), config.getString("kits."+ name +".code"));
        ArrayList lore = new ArrayList<String>();
        for(String loren : Main.getInstance().getConfig().getStringList("kits."+ name +".lore")){
            lore.add(applyColor(loren));
        }
        head.setLore(lore);
        return head.getHead();
    }

    private final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
    public String applyColor(String message){
        Matcher matcher = hexPattern.matcher(message);
        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = message.substring(0, matcher.start());
            final String after = message.substring(matcher.end());
            message = before + hexColor + after;
            matcher = hexPattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
