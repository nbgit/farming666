package entora.farming666.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import entora.farming666.utils.TrampleUtils;

//import farmland material

public class CropTrampleListener implements Listener {
    //create a method that listens for a crop being trampled
    //if the player is trampling crops, do nothing
    //if the player is not trampling crops, cancel the event
    @EventHandler
    public static void onCropTrample(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.FARMLAND ) {
           int isTrampling = TrampleUtils.getTrampleData(event.getPlayer());
           if (isTrampling == 0) {
           event.setCancelled(true);
            }
        }

    }
}
