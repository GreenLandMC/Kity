package me.GGGEDR.Kity.Command.Admin;

import me.GGGEDR.Kity.Api.Configurator;
import me.GGGEDR.Kity.Api.KitsItems;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] argumnty) {
        if(sender.hasPermission("kit.admin.*")){
            if(argumnty.length == 0){
                sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                sender.sendMessage("§a/akit give <kit> [player] §8- §7Give kit to player");
                sender.sendMessage("§a/akit set <kit> §8- §7Set items in kit");
                sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
            } else if(argumnty.length == 1) {
                if (argumnty[0].equalsIgnoreCase("give")) {
                    sender.sendMessage("§a§lAKit §8» §7Use: §a/akit give <kit> [player]");
                    sender.sendMessage("§a* §7Kits: "+ ChatColor.of(Color.decode("#e3051b")) +"Christmas§7,"+ ChatColor.of(Color.decode("#bb00ff")) +" Mythic§7, "+ ChatColor.of(Color.decode("#cc5a18")) +"Classic§7, "+ ChatColor.of(Color.decode("#411fcc")) +"Gangster");
                } else {
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                    sender.sendMessage("§a/akit give <kit> [player] §8- §7Give kit to player");
                    sender.sendMessage("§a/akit set <kit> §8- §7Set items in kit");
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                }
            } else if(argumnty.length == 2){
                if (argumnty[0].equalsIgnoreCase("give")) {
                    KitsItems kity = new KitsItems();
                    if(argumnty[1].equalsIgnoreCase("Christmas")){
                        ((Player) sender).getInventory().addItem(kity.getChristmasHead());
                        sender.sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#e3051b")) +"§lChristmas Kit");
                    } else if(argumnty[1].equalsIgnoreCase("Mythic")){
                        ((Player) sender).getInventory().addItem(kity.getMythicHead());
                        sender.sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#bb00ff")) +"§lMythic Kit");
                    } else if(argumnty[1].equalsIgnoreCase("Classic")){
                        ((Player) sender).getInventory().addItem(kity.getClassicHead());
                        sender.sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit");
                    } else if(argumnty[1].equalsIgnoreCase("Gangster")){
                        ((Player) sender).getInventory().addItem(kity.getGangsterHead());
                        sender.sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#411fcc")) +"§lGangster Kit");
                    } else {
                        sender.sendMessage("§a§lAKit §8» §7Use: §a/akit give <kit> [player]");
                        sender.sendMessage("§a* §7Kits: "+ ChatColor.of(Color.decode("#e3051b")) +"Christmas§7,"+ ChatColor.of(Color.decode("#bb00ff")) +" Mythic§7, "+ ChatColor.of(Color.decode("#cc5a18")) +"Classic§7, "+ ChatColor.of(Color.decode("#411fcc")) +"Gangster");
                    }
                } else if(argumnty[0].equalsIgnoreCase("set")){
                    if(argumnty[1].equalsIgnoreCase("Christmas")){
                        Configurator configurator = new Configurator("christmas");
                        try {
                            configurator.setItems((Player) sender);
                            sender.sendMessage("§a§lKit §8» §7Upravil si kit: "+ ChatColor.of(Color.decode("#e3051b")) +"§lChristmas Kit");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Mythic")){
                        Configurator configurator = new Configurator("mythic");
                        try {
                            configurator.setItems((Player) sender);
                            sender.sendMessage("§a§lKit §8» §7Upravil si kit: "+ ChatColor.of(Color.decode("#bb00ff")) +"§lMythic Kit");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Classic")){
                        Configurator configurator = new Configurator("classic");
                        try {
                            configurator.setItems((Player) sender);
                            sender.sendMessage("§a§lKit §8» §7Upravil si kit: "+ ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Gangster")){
                        Configurator configurator = new Configurator("gangster");
                        try {
                            configurator.setItems((Player) sender);
                            sender.sendMessage("§a§lKit §8» §7Upravil si kit: "+ ChatColor.of(Color.decode("#411fcc")) +"§lGangster Kit");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage("§a§lAKit §8» §7Use: §a/akit give <kit> [player]");
                        sender.sendMessage("§a* §7Kits: "+ ChatColor.of(Color.decode("#e3051b")) +"Christmas§7,"+ ChatColor.of(Color.decode("#bb00ff")) +" Mythic§7, "+ ChatColor.of(Color.decode("#cc5a18")) +"Classic§7, "+ ChatColor.of(Color.decode("#411fcc")) +"Gangster");
                    }
                } else {
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                    sender.sendMessage("§a/akit give <kit> [player] §8- §7Give kit to player");
                    sender.sendMessage("§a/akit set <kit> §8- §7Set items in kit");
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                }
            } else if(argumnty.length == 3) {
                if (argumnty[0].equalsIgnoreCase("give")) {
                    KitsItems kity = new KitsItems();
                    if(argumnty[1].equalsIgnoreCase("Christmas")){
                        if(Bukkit.getPlayer(argumnty[2]) != null) {
                            Bukkit.getPlayer(argumnty[2]).getInventory().addItem(kity.getChristmasHead());
                            sender.sendMessage("§a§lKit §8» §7Dal si: " + ChatColor.of(Color.decode("#e3051b")) + "§lChristmas Kit §7Hráčovi: §a"+ argumnty[2]);
                            Bukkit.getPlayer(argumnty[2]).sendMessage("§a§lKit §8» §7Dostal si: " + ChatColor.of(Color.decode("#e3051b")) + "§lChristmas Kit");
                        } else {
                            sender.sendMessage("§a§lKit §8» §7This user is offline!");
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Mythic")){
                        if(Bukkit.getPlayer(argumnty[2]) != null) {
                            Bukkit.getPlayer(argumnty[2]).getInventory().addItem(kity.getMythicHead());
                            sender.sendMessage("§a§lKit §8» §7Dal si: " + ChatColor.of(Color.decode("#bb00ff")) + "§lMythic Kit §7Hráčovi: §a"+ argumnty[2]);
                            Bukkit.getPlayer(argumnty[2]).sendMessage("§a§lKit §8» §7Dostal si: " + ChatColor.of(Color.decode("#bb00ff")) + "§lMythic Kit");
                        } else {
                            sender.sendMessage("§a§lKit §8» §7This user is offline!");
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Classic")){
                        if(Bukkit.getPlayer(argumnty[2]) != null) {
                            Bukkit.getPlayer(argumnty[2]).getInventory().addItem(kity.getClassicHead());
                            sender.sendMessage("§a§lKit §8» §7Dal si: "+ ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit §7Hráčovi: §a"+ argumnty[2]);
                            Bukkit.getPlayer(argumnty[2]).sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit");
                        } else {
                            sender.sendMessage("§a§lKit §8» §7This user is offline!");
                        }
                    } else if(argumnty[1].equalsIgnoreCase("Gangster")){
                        if(Bukkit.getPlayer(argumnty[2]) != null) {
                            Bukkit.getPlayer(argumnty[2]).getInventory().addItem(kity.getGangsterHead());
                            sender.sendMessage("§a§lKit §8» §7Dal si: "+ ChatColor.of(Color.decode("#411fcc")) +"§lGangster Kit §7Hráčovi: §a"+ argumnty[2]);
                            Bukkit.getPlayer(argumnty[2]).sendMessage("§a§lKit §8» §7Dostal si: "+ ChatColor.of(Color.decode("#411fcc")) +"§lGangster Kit");
                        } else {
                            sender.sendMessage("§a§lKit §8» §7This user is offline!");
                        }
                    } else {
                        sender.sendMessage("§a§lAKit §8» §7Use: §a/akit give <kit> [player]");
                        sender.sendMessage("§a* §7Kits: "+ ChatColor.of(Color.decode("#e3051b")) +"Christmas§7,"+ ChatColor.of(Color.decode("#bb00ff")) +" Mythic§7, "+ ChatColor.of(Color.decode("#cc5a18")) +"Classic§7, "+ ChatColor.of(Color.decode("#411fcc")) +"Gangster");
                    }
                } else {
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                    sender.sendMessage("§a/akit give <kit> [player] §8- §7Give kit to player");
                    sender.sendMessage("§a/akit set <kit> §8- §7Set items in kit");
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                }
            } else {
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
                    sender.sendMessage("§a/akit give <kit> [player] §8- §7Give kit to player");
                    sender.sendMessage("§a/akit set <kit> §8- §7Set items in kit");
                    sender.sendMessage("§8» » » »  §a§lKits - Help  §8« « « «");
            }
        } else {
            sender.sendMessage("§cYou are not allowed");
        }
        return false;
    }
}
