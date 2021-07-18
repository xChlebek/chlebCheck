package xchlebek.chlebcheck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class sprawdzCommand extends JavaPlugin implements Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sprawdz")) {
            if (!sender.hasPermission("chlebcheck.admin")) {
                sender.sendMessage("§cNie masz permisji do tej komendy!");
                return true;
            }

            if (args.length == 0) {
                String n = args[0];
                Player pa = Bukkit.getPlayer(n);
                if (Bukkit.getPlayer(n) != null) {
                    pa.sendMessage("§aJestes sprawdzany!");
                    sender.sendMessage(pa.getName() + " §cJest sprawdzany!");
                    return true;
                }

                sender.sendMessage("§cPodany gracz jest offline!");
                return true;
            }

            sender.sendMessage("§cPrawidlowe uzycie: /sprawdz <nick>");
        }

        return false;
    }
}
