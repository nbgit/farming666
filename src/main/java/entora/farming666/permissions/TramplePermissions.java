package entora.farming666.permissions;
import entora.farming666.Farming666;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
//import player
import org.bukkit.entity.Player;

public class TramplePermissions {
    public static void setTramplePermission(Player player, int trample) {
        //get the players persistent data container
        //create a namespaced key with the farming666 plugin as the plugin and "canTrample" as the key


        PersistentDataContainer container = player.getPersistentDataContainer();
        //set the persistent data container to a new persistent data container
        container.set(new NamespacedKey(Farming666.getPlugin(Farming666.class),"canTrample"), PersistentDataType.INTEGER, trample);
    }
    //create a method to get the persistent data value with the key "canTrample" from a given player
    public static int getTramplePermission(Player player) {
        //get the players persistent data container
        PersistentDataContainer container = player.getPersistentDataContainer();
        //get the persistent data value with the key "canTrample" from the players persistent data container
        if (container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class),"canTrample"), PersistentDataType.INTEGER) == null) {
            return 0;
        }
        int trample = container.get(new NamespacedKey(Farming666.getPlugin(Farming666.class),"canTrample"), PersistentDataType.INTEGER);
        //return the persistent data value with the key "canTrample" from the players persistent data container
        return trample;
    }
}
