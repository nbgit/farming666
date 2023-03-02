package entora.farming666.listeners;

import entora.farming666.utils.CropUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public class CropPistonListener implements Listener {
    //create a method that listens for a piston extending into a crop
    @EventHandler
    public static void onCropPistonExtend(BlockPistonExtendEvent event){
        Block block = event.getBlock().getRelative(event.getDirection());
        //if a piston extends into a crop, break the crop and drop no items
        if (CropUtils.isCrop(block)) {
            block.setType(Material.AIR);
        }
    }









}
