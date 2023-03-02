package entora.farming666.commands;

import entora.farming666.permissions.ModPermissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 1) {
            Player player = (Player) sender;
            Player target = player.getServer().getPlayer(args[0]);
            if (ModPermissions.getisMod(player) == 1) {

                if (target == null) {
                    player.sendMessage("The target is not online!");
                    return false;
                }
                int isMod = ModPermissions.getisMod(target);
                switch (isMod) {
                    case 0:
                        ModPermissions.setisMod(target, 1);
                        target.sendMessage("You are now a mod!");
                        player.sendMessage("The target is now a mod!");
                        return true;
                    case 1:
                        ModPermissions.setisMod(target, 0);
                        target.sendMessage("You are no longer a mod!");
                        player.sendMessage("The target is no longer a mod!");
                        return true;
                }
            } else {
                player.sendMessage("You do not have permission to use this command!");
                return false;
            }


        }

    return false;}
}
