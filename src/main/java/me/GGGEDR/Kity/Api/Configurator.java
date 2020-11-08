package me.GGGEDR.Kity.Api;

import me.GGGEDR.Kity.Main;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

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
                if (this.kit.equalsIgnoreCase("christmas")) {
                    p.getInventory().removeItem(kits.getChristmasHead());
                }
                if (this.kit.equalsIgnoreCase("gangster")) {
                    p.getInventory().removeItem(kits.getGangsterHead());
                }
                if (this.kit.equalsIgnoreCase("mythic")) {
                    p.getInventory().removeItem(kits.getMythicHead());
                }
                if (this.kit.equalsIgnoreCase("classic")) {
                    p.getInventory().removeItem(kits.getClassicHead());
                }
                if (this.kit.equalsIgnoreCase("shulker")) {
                    p.getInventory().removeItem(kits.getShulkerHead());
                }
                if (this.kit.equalsIgnoreCase("builder")) {
                    p.getInventory().removeItem(kits.getBuilderHead());
                }
                for (int i = 0; i < treba_slotov; i++) {
                    int hmm = i + 1;
                    ItemStack item = yamlConfiguration.getItemStack("kits." + kit + ".items." + hmm);
                    p.getInventory().addItem(item);
                    p.sendMessage("§a§l+ §7| §a" + item.getType().name().toLowerCase().replace("_", " ") +" §b"+ item.getAmount() +"x");
                }
                p.sendMessage("§a§lKit §8» §7Aktivoval si si svoj kit!");
            } else {
                p.sendMessage("§a§lKit §8» §7Nemáš dostatočný počet volných slotov v inventáry! §fTreba: §a" + treba_slotov +" §7| §fMáš: §a"+ getEmptySlots(p.getInventory()));
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
}
