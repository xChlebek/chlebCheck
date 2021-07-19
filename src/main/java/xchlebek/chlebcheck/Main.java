package xchlebek.chlebcheck;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        getCommand("czysty").setExecutor(new czystyCommand());
        getCommand("sprawdz").setExecutor(new sprawdzCommand());
        Bukkit.getConsoleSender().sendMessage(Util.fix("§a§lPlugin zostal pomyslnie zaladowany!"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Util.fix("§c§lPomyslnie wylaczono plugin!"));
    }

    public static Main getInstance() {
        return instance;
    }
}

