package me.GGGEDR.Kity.Command.Admin;

import me.GGGEDR.Kity.Api.Configurator;
import me.GGGEDR.Kity.Api.KitsItems;
import me.GGGEDR.Kity.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] argumnty) {
        if(sender.hasPermission("kit.admin.*")){
            if(argumnty.length == 0) {
                sendList(sender, "messages.akit.help");
            } else if(argumnty.length == 1) {
                if (argumnty[0].equalsIgnoreCase("give")) {
                    File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
                    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                    ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
                    HashMap<String, String> replacements = new HashMap<>();
                    String kits = null;
                    for(String kit : configurationSection.getKeys(false)){
                        if(kits == null){
                            kits = kit;
                        } else {
                            kits = kits + yamlConfiguration.getString("messages.akit.subbers.kit-list.") + kit;
                        }
                    }
                    replacements.put("list.kits", applyColor(kits));
                    sendList(sender, "messages.akit.give.use", replacements);
                } else {
                    sendList(sender, "messages.akit.help");
                }
            } else if(argumnty.length == 2){
                if (argumnty[0].equalsIgnoreCase("give")) {
                    KitsItems kity = new KitsItems();
                    File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
                    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                    ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
                    if(configurationSection != null) {
                        if (configurationSection.getKeys(false).contains(argumnty[1])) {
                            ((Player) sender).getInventory().addItem(kity.getKitHead(argumnty[1]));
                            HashMap<String, String> replacements = new HashMap<>();
                            replacements.put("kit.Name", applyColor(yamlConfiguration.getString("kits."+ argumnty[1] +".name")));
                            sendList(sender, "messages.akit.give.receive", replacements);
                        } else {
                            HashMap<String, String> replacements = new HashMap<>();
                            String kits = null;
                            for(String kit : configurationSection.getKeys(false)){
                                if(kits == null){
                                    kits = kit;
                                } else {
                                    kits = kits + yamlConfiguration.getString("messages.akit.subbers.kit-list") + kit;
                                }
                            }
                            replacements.put("list.kits", applyColor(kits));
                            sendList(sender, "messages.akit.give.use", replacements);
                        }
                    } else {
                        sendMessage(sender, "messages.akit.errors.no-kits");
                    }
                } else if(argumnty[0].equalsIgnoreCase("set")){
                    File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
                    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                    ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
                    if(configurationSection != null) {
                        if (configurationSection.getKeys(false).contains(argumnty[1])) {
                            Configurator configurator = new Configurator(argumnty[1]);
                            try {
                                configurator.setItems((Player) sender);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            HashMap<String, String> replacements = new HashMap<>();
                            replacements.put("kit.Name", applyColor(yamlConfiguration.getString("kits."+ argumnty[1] +".name")));
                            sendList(sender, "messages.akit.set.done", replacements);
                        } else {
                            HashMap<String, String> replacements = new HashMap<>();
                            String kits = null;
                            for(String kit : configurationSection.getKeys(false)){
                                if(kits == null){
                                    kits = kit;
                                } else {
                                    kits = kits + yamlConfiguration.getString("messages.akit.subbers.kit-list.") + kit;
                                }
                            }
                            replacements.put("list.kits", applyColor(kits));
                            sendList(sender, "messages.akit.give.use", replacements);
                        }
                    } else {
                        sendMessage(sender, "messages.akit.errors.no-kits");
                    }
                } else {
                    sendList(sender, "messages.akit.help");
                }
            } else if(argumnty.length == 3) {
                if (argumnty[0].equalsIgnoreCase("give")) {
                    KitsItems kity = new KitsItems();
                    File config = new File(Main.getInstance().getDataFolder() + "/config.yml");
                    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                    ConfigurationSection configurationSection = yamlConfiguration.getConfigurationSection("kits");
                    if(configurationSection != null) {
                        if (configurationSection.getKeys(false).contains(argumnty[1])) {
                            if(Bukkit.getPlayer(argumnty[2]) != null) {
                                if(getEmptySlots(Bukkit.getPlayer(argumnty[2]).getInventory()) >= 1) {
                                    HashMap<String, String> replacements = new HashMap<>();
                                    replacements.put("kit.Name", applyColor(yamlConfiguration.getString("kits." + argumnty[1] + ".name")));
                                    Bukkit.getPlayer(argumnty[2]).getInventory().addItem(kity.getKitHead(argumnty[1]));
                                    sendList(sender, "messages.akit.give.receive-other", replacements);
                                    sendList(Bukkit.getPlayer(argumnty[2]), "messages.akit.give.receive", replacements);
                                } else {
                                    sendMessage(sender, "messages.akit.errors.no-slot");
                                }
                            } else {
                                sendList(sender, "messages.akit.errors.offline");
                            }
                        } else {
                            HashMap<String, String> replacements = new HashMap<>();
                            String kits = null;
                            for(String kit : configurationSection.getKeys(false)){
                                if(kits == null){
                                    kits = kit;
                                } else {
                                    kits = kits + yamlConfiguration.getString("messages.akit.subbers.kit-list.") + kit;
                                }
                            }
                            replacements.put("list.kits", applyColor(kits));
                            sendList(sender, "messages.akit.give.use", replacements);
                        }
                    } else {
                        sendMessage(sender, "messages.akit.errors.no-kits");
                    }
                } else {
                    sendList(sender, "messages.akit.help");
                }
            } else {
                sendList(sender, "messages.akit.help");
            }
        } else {
            sendMessage(sender, "messages.akit.errors.no-permission");
        }
        return false;
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
