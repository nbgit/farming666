package entora.farming666.listeners;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import entora.farming666.utils.CropUtils;
public class UnderCropListener implements Listener {
    @EventHandler
    public void onUnderCropBreak(BlockBreakEvent event) {
        //if the block above the block broken is a crop, break the crop and drop no items
        if(CropUtils.isCrop(event.getBlock().getRelative(0, 1, 0))) {
            event.getBlock().getRelative(0,1,0).setType(Material.AIR);}

    }
}
