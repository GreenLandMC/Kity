package me.GGGEDR.Kity;

import me.GGGEDR.Kity.Command.Admin.Admin;
import me.GGGEDR.Kity.Command.Admin.TabComplete;
import me.GGGEDR.Kity.Listeners.Click;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getDataFolder().mkdir();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getServer().getPluginCommand("akit").setExecutor(new Admin());
        this.getServer().getPluginCommand("akit").setTabCompleter(new TabComplete());
        this.getServer().getPluginManager().registerEvents(new Click(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance(){
        return instance;
    }
}
