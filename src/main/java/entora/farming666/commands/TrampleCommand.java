package entora.farming666.commands;

import entora.farming666.permissions.ModPermissions;
import entora.farming666.utils.TrampleUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import entora.farming666.permissions.TramplePermissions;


public class TrampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;
            if (TramplePermissions.getTramplePermission(player) == 1) {
                int isTrampling = TrampleUtils.getTrampleData(player);
                switch (isTrampling) {
                    case 0:
                        TrampleUtils.setTrampleData(player, 1);
                        player.sendMessage("You can now trample crops!");
                        return true;
                    case 1:
                        TrampleUtils.setTrampleData(player, 0);
                        player.sendMessage("You can no longer trample crops!");
                        return true;
                }
            }
        }
        if (sender instanceof Player && args.length == 1) {

            Player player = (Player) sender;
            Player target = player.getServer().getPlayer(args[0]);
            boolean b = player == target && TramplePermissions.getTramplePermission(player) == 1;
            if (ModPermissions.getisMod(player) == 1  || b) {
                if (target == null) {
                    player.sendMessage("The target is not online!");
                    return false;
                }
                int isTrampling = TrampleUtils.getTrampleData(target);
                switch (isTrampling) {
                    case 0:
                        TrampleUtils.setTrampleData(target, 1);
                        target.sendMessage("You can now trample crops!");
                        player.sendMessage("The target can now trample crops!");
                        return true;
                    case 1:
                        TrampleUtils.setTrampleData(target, 0);
                        target.sendMessage("You can no longer trample crops!");
                        player.sendMessage("The target can no longer trample crops!");
                        return true;
                }
            }
            player.sendMessage("You must be a moderator to toggle if another player can trample!");
            return false;
        }


   sender.sendMessage("Something went wrong! Contact a developer.");
    return false;}
}




