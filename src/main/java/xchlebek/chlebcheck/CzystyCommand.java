package xchlebek.chlebcheck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Collections;
import java.util.List;


public class CzystyCommand implements Listener, CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

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

    public static boolean isChecking;

    {
        isChecking = true;
    }

    @EventHandler
    public void playerMove(PlayerMoveEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void processCommand(PlayerCommandPreprocessEvent e) {
        e.setCancelled(true);
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.singletonList("Raymano");
    }
}
