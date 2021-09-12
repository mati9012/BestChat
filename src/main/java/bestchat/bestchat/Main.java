package bestchat.bestchat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Player players = (Player) Bukkit.getOnlinePlayers();
        if(cmd.getName().equalsIgnoreCase("chat")){
            if(p.hasPermission("bestchat.clear") || p.isOp()) {
                if(args.length < 0) {
                    p.sendMessage(getConfig().getString("messange.uzycie"));
                }
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("clear")) {
                        for(int i = 0; i < 101; i++) {
                            players.sendMessage(" ");

                        }
                        for(Player players2 : Bukkit.getOnlinePlayers()) {
                            players2.sendMessage(getConfig().getString("messange.1"));
                            players2.sendMessage(getConfig().getString("messange.2"));
                            players2.sendMessage(getConfig().getString("messange.3"));
                            players2.sendMessage(getConfig().getString("messange.4"));
                        }
                    }
                }
            }else {
                p.sendMessage(getConfig().getString("messange.permisja"));
            }
        }
        return false;
    }


    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§6Plugin się włącza!");
        getConfig().options().copyDefaults(true);
        saveConfig();

    }


}
