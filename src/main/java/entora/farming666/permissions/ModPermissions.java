package entora.farming666.permissions;

import entora.farming666.Farming666;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ModPermissions {
    public static void setisMod(Player player, int trample) {
        //get the players persistent data container
        //create a namespaced key with the farming666 plugin as the plugin and "isMod" as the key


        PersistentDataContainer container = player.getPersistentDataContainer();
        container.set(new NamespacedKey(Farming666.getPlugin(Farming666.class),"isMod"), PersistentDataType.INTEGER, trample);
    }
    //create a method to get the persistent data value with the key "isMod" from a given player
    public static int getisMod(Player player) {
        if (player.isOp()) {
            return 1;
        }
        PersistentDataContainer container = player.getPersistentDataContainer();
        //get the persistent data value with the key "isMod" from the players persistent data container
        //if its null, simply return 0 -- they don't got no perms! we don't want nulls!
        if (container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class),"isMod"), PersistentDataType.INTEGER) == null) {
            return 0;
        } else {
            //return the persistent data value with the key "isMod" from the players persistent data container if its not null, because there's a value set.
            return container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class),"isMod"), PersistentDataType.INTEGER);
        }

    }
}
