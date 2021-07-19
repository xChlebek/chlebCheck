package xchlebek.chlebcheck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class czystyCommand extends JavaPlugin implements Listener {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("czysty")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;

                if (args.length > 0) {
                    Player target = Bukkit.getPlayer(args[0]);

                    target.sendMessage("§2Zostales oczyszczony.");

                    p.sendMessage("§2Oczysciles gracza " + (args[0]) + "§2.");
                }
            }
            return true;
        }

        return false;
    }
}
