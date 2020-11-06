package me.GGGEDR.Kity.Api;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class Head {

    ItemStack itemStack;

    public Head(String displayName, String texture, String name){
        itemStack = SkullManager.itemFromBase64(texture, name);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);
    }

    public void setLore(List<String> lore){
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
    }


    public ItemStack getHead(){
        return itemStack;
    }
}
