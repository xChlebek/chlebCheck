package xchlebek.chlebcheck;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(Util.fix("§a§lPlugin zostal pomyslnie zaladowany!"));
        getCommand("czysty").setExecutor(new CzystyCommand());
//        getCommand("czysty").setTabCompleter(new CzystyCommand());
        getServer().getPluginManager().registerEvents(new CzystyCommand(),this);
        getCommand("sprawdz").setExecutor(new SprawdzCommand());
        getServer().getPluginManager().registerEvents(new SprawdzCommand(),this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Util.fix("§c§lPomyslnie wylaczono plugin!"));
    }

    public static Main getInstance() {
        return instance;
    }
}
/**
 * ctr + alt + o
 * ctr + alt + d
 * ctr + alt + l
 * shift + F6
 * ctr + /
 * alt + ins
 */
