package entora.farming666.commands;

import com.sun.org.apache.xpath.internal.operations.Mod;
import entora.farming666.permissions.ModPermissions;
import entora.farming666.permissions.TramplePermissions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Player;


public class canTrampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //create a method to set if a player has the permission to use the trample command
        //if the player is a mod, they can use this command
        //if the player is not a mod, they cannot use this command

        if(sender instanceof Player && args.length == 1){

            Player player = (Player) sender;
            Player target = player.getServer().getPlayer(args[0]);
            if (ModPermissions.getisMod(player) == 1){
            if (target == null){
                player.sendMessage("The target is not online!");
                return false;

            }
            if (TramplePermissions.getTramplePermission(target) == 1){
                TramplePermissions.setTramplePermission(target, 0);
                target.sendMessage("You can no longer use the /trample command!");
                player.sendMessage("The target can no longer use the /trample command!");
                return true;

            }
            if (TramplePermissions.getTramplePermission(target) == 0){
                TramplePermissions.setTramplePermission(target, 1);
                target.sendMessage("You can now use the /trample command!");
                player.sendMessage("The target can now use the /trample command!");
                return true;
            }
            }
            else {
                player.sendMessage("You do not have permission to use this command!");
                return false;
            }

        }
        return false;


    }
}
