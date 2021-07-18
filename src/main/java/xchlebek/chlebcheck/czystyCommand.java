package xchlebek.chlebcheck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class czystyCommand extends JavaPlugin implements Listener {

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        Player player = (Player) sender;
        if (alias.equalsIgnoreCase("czysty")) {
            if (!sender.hasPermission("chlebcheck.admin")) {
                player.sendMessage("§c§lNie masz permisji do tej komendy!");
                return true;
            }

            if (args.length == 0) {
                //Player only typed '/czysty' so lets teleport them back!
                player.sendMessage("§c§lNie możesz oczyścić samego siebie!");
            } else {
                //Player typed something more
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    //Target is not online
                    player.sendMessage("§7Gracz §6" + args[0] + " §7jest offline!");
                } else {
                    //Targets online
                    player.sendMessage("§7Gracz §6" + args[0] + " §7jest czysty!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn args[0]");
                }
            }
        }
        return false;
    }
}
