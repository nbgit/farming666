package entora.farming666.utils;

import entora.farming666.Farming666;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TrampleUtils {
    //create a method to set a new persistent data container for a given player

    public static void setTrampleData(Player player, int trample) {
        //get the players persistent data container
        //create a namespaced key with the farming666 plugin as the plugin and "isTrampling" as the key


        PersistentDataContainer container = player.getPersistentDataContainer();
        //set the persistent data container to a new persistent data container
        container.set(new NamespacedKey(Farming666.getPlugin(Farming666.class),"isTrampling"), PersistentDataType.INTEGER, trample);
    }
    //create a method to get the persistent data value with the key "isTrampling" from a given player
public static int getTrampleData(Player player) {
    //get the players persistent data container
    PersistentDataContainer container = player.getPersistentDataContainer();
    //get the persistent data value with the key "canTrample" from the players persistent data container
    if (container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class), "isTrampling"), PersistentDataType.INTEGER) == null) {
        return 0;
    } else {
        //return the persistent data value with the key "isTrampling" from the players persistent data container


        return container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class), "isTrampling"), PersistentDataType.INTEGER);
    }
}
}

