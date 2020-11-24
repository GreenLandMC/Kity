package me.GGGEDR.Kity.Api;

import me.GGGEDR.Kity.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configurator {

    String kit;
    File config = new File(Main.getInstance().getDataFolder() + "/config.yml");

    public Configurator(String kit){
        this.kit = kit;
    }

    public void setItems(Player player) throws IOException {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
        if(yamlConfiguration.getConfigurationSection("kits."+ kit +".items") != null){
            for (String s : yamlConfiguration.getConfigurationSection("kits." + kit + ".items").getKeys(true)) {
                yamlConfiguration.set("kits." + kit + ".items." + s, null);
            }
        }
        int itemer = 0;
        for(int i = 0; i < player.getInventory().getContents().length; i++){
            if(player.getInventory().getContents()[i] != null) {
                itemer++;
                yamlConfiguration.set("kits." + kit + ".items." + itemer, player.getInventory().getContents()[i]);
            }
        }
        yamlConfiguration.save(config);
    }

    public void activeKit(Player p){
        this.config = new File(Main.getInstance().getDataFolder() + "/config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
        ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits."+ this.kit +".items");
        if(configurationSection != null) {
            int treba_slotov = configurationSection.getKeys(false).size();
            if (getEmptySlots(p.getInventory()) >= treba_slotov) {
                KitsItems kits = new KitsItems();
                p.getInventory().removeItem(kits.getKitHead(this.kit));
                for (int i = 0; i < treba_slotov; i++) {
                    int hmm = i + 1;
                    ItemStack item = yamlConfiguration.getItemStack("kits." + kit + ".items." + hmm);
                    p.getInventory().addItem(item);
                    HashMap<String, String> replacements = new HashMap<>();
                    replacements.put("item", item.getType().name().toLowerCase().replace("_", " "));
                    replacements.put("amount", ""+item.getAmount());
                    sendMessage(p, "messages.akit.use.kit.item-pattern", replacements);
                }
                sendMessage(p, "messages.akit.use.kit.kit-used");
            } else {
                HashMap<String, String> reaplaments = new HashMap<>();
                reaplaments.put("kit.slots.number", ""+ treba_slotov);
                sendList(p, "messages.akit.use.kit.no-slots", reaplaments);
            }
        }
    }

    public int getEmptySlots(Inventory inventory) {
        int i = 0;
        for (ItemStack is : inventory.getContents()) {
            if (is == null) {
                i++;
            }
        }
        return i;
    }

    public void sendList(CommandSender sender, String location, HashMap<String, String> replacements){
        FileConfiguration config = Main.getInstance().getConfig();
        replacements.put("prefixes.admin", config.getString("messages.akit.prefixes.admin"));
        replacements.put("prefixes.default", config.getString("messages.akit.prefixes.default"));
        for(String str : Main.getInstance().getConfig().getStringList(location)){
            sendWithReplacement(sender, str, replacements);
        }
    }

    public void sendList(CommandSender sender, String location){
        HashMap<String, String> replacements = new HashMap<>();
        FileConfiguration config = Main.getInstance().getConfig();
        replacements.put("prefixes.admin", config.getString("messages.akit.prefixes.admin"));
        replacements.put("prefixes.default", config.getString("messages.akit.prefixes.default"));
        for(String str : Main.getInstance().getConfig().getStringList(location)){
            sendWithReplacement(sender, str, replacements);
        }
    }

    public void sendMessage(CommandSender sender, String location){
        HashMap<String, String> replacements = new HashMap<>();
        FileConfiguration config = Main.getInstance().getConfig();
        replacements.put("prefixes.admin", config.getString("messages.akit.prefixes.admin"));
        replacements.put("prefixes.default", config.getString("messages.akit.prefixes.default"));
        sendWithReplacement(sender, Main.getInstance().getConfig().getString(location), replacements);
    }

    public void sendMessage(CommandSender sender, String location, HashMap<String, String> replacements){
        FileConfiguration config = Main.getInstance().getConfig();
        replacements.put("prefixes.admin", config.getString("messages.akit.prefixes.admin"));
        replacements.put("prefixes.default", config.getString("messages.akit.prefixes.default"));
        sendWithReplacement(sender, Main.getInstance().getConfig().getString(location), replacements);
    }

    public void sendWithReplacement(CommandSender sender, String msg, HashMap<String, String> replacements){
        String ehm = msg;
        for(String replacement : replacements.keySet()){
            ehm = ehm.replace("["+ replacement +"]", replacements.get(replacement));
        }
        ehm = applyColor(ehm);
        sender.sendMessage(ehm);
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
