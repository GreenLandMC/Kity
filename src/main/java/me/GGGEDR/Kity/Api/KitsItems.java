package me.GGGEDR.Kity.Api;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.util.ArrayList;

public class KitsItems {

    public ItemStack getChristmasHead(){
        Head head = new Head(ChatColor.of(Color.decode("#e3051b")) +"§lChristmas Kit", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjA4MDAzYWUxZGVjNjQxN2IxNDA3MDQ2MjdhMDA3MTk2ZTUxNmFlZWM5YjM5NGFmNzhkNzAxOTJjOGUzNTE1ZCJ9fX0=", "aiDe3INQ");
        ArrayList lore = new ArrayList<String>();
        lore.add(ChatColor.of(Color.decode("#e3051b")) +"» §fClick to open");
        lore.add(ChatColor.of(Color.decode("#e3051b")) +"» "+ ChatColor.of(Color.decode("#f76f7d")) +"Description:");
        lore.add("§fVánoční dárek");
        lore.add("§fOd GreenLandMC Teamu");
        head.setLore(lore);
        return head.getHead();
    }

    public ItemStack getMythicHead(){
        Head head = new Head(ChatColor.of(Color.decode("#bb00ff")) +"§lMythic Kit","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzljN2YxZGIxY2UyMWFkMGQyYzVkMTEyNDY2ZWVhNzk4NGRhM2EwMTMzMzBlMTBhYzljMWU3OWQxNjAyNWU5MiJ9fX0=", "tzehQYlx");
        ArrayList lore = new ArrayList<String>();
        lore.add(ChatColor.of(Color.decode("#bb00ff")) +"» §fClick to open");
        lore.add(ChatColor.of(Color.decode("#bb00ff")) +"» "+ ChatColor.of(Color.decode("#ca56f5")) +"Description:");
        lore.add("§fHmm tieto itemy smrdí mágiov");
        lore.add("§fDávej si pozor člověče!");
        head.setLore(lore);
        return head.getHead();
    }

    public ItemStack getClassicHead(){
        Head head = new Head(ChatColor.of(Color.decode("#cc5a18")) +"§lClassic Kit","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc1ZTc5NDg4ODQ3YmEwMmQ1ZTEyZTcwNDJkNzYyZTg3Y2UwOGZhODRmYjg5YzM1ZDZiNWNjY2I4YjlmNGJlZCJ9fX0=", "q5ImKCLN");
        ArrayList lore = new ArrayList<String>();
        lore.add(ChatColor.of(Color.decode("#cc5a18")) +"» §fClick to open");
        lore.add(ChatColor.of(Color.decode("#cc5a18")) +"» "+ ChatColor.of(Color.decode("#c96e38")) +"Description:");
        lore.add("§fTaký survival základ");
        head.setLore(lore);
        return head.getHead();
    }

    public ItemStack getGangsterHead(){
        Head head = new Head(ChatColor.of(Color.decode("#411fcc")) +"§lGangster Kit","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzJlNjA4MWM4MjVlODM5NzdhNjE0ODI4YjE5ZmFiNThjMWY2ZTYzMzcwY2IxMDk1ZGE1MzU5ODQwZDhjZTExNiJ9fX0=", "3GpdlqHL");
        ArrayList lore = new ArrayList<String>();
        lore.add(ChatColor.of(Color.decode("#411fcc")) +"» §fClick to open");
        lore.add(ChatColor.of(Color.decode("#411fcc")) +"» "+ ChatColor.of(Color.decode("#6348cf")) +"Description:");
        lore.add("§fPravý Gangsterský Balíček");
        head.setLore(lore);
        return head.getHead();
    }

}
