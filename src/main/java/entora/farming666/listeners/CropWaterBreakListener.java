package entora.farming666.listeners;

import entora.farming666.utils.CropUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class CropWaterBreakListener implements Listener {
    //create a method that listens for water breaking a crop
    @EventHandler
    public static void onCropWaterBreak(BlockFromToEvent event) {
        //if water or lava flows into a crop, break the crop and drop no items
        Block block = event.getToBlock();
        if (CropUtils.isCrop(block)) {
            event.setCancelled(true);
            block.setType(Material.AIR);

        }
    }

}
