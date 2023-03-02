package entora.farming666.listeners;

import entora.farming666.utils.CropUtils;
import entora.farming666.utils.HoeUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class CropBreakListener implements Listener {
    //create a method that listens for a crop break event
    @EventHandler
    public static void onCropBreak(BlockBreakEvent event) {
        //if the crop block is a crop and is fully grown, drop the correct amount of crops and seeds
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (CropUtils.isCrop(block)) {
            if (CropUtils.isCropFullyGrown(block) && HoeUtils.isPlayerHoldingHoe(player)) {
                int amount = HoeUtils.howMany(HoeUtils.getHoeType(player));
                int seedamount = HoeUtils.randomSeeds();
                Location location = block.getLocation();
                ItemStack[] drops = CropUtils.whatDrops(block, amount, seedamount);
                //drop the items
                for (ItemStack itemStack : drops) {
                    location.getWorld().dropItemNaturally(location, itemStack);


                }
            }
            //if the player has a damageable item hoe or not, its taking damage! Crops break your tools cuz crops stronk :)
            if (player.getInventory().getItemInMainHand().getItemMeta() instanceof Damageable && !player.getInventory().getItemInMainHand().getItemMeta().isUnbreakable()){
                Damageable damageable = (Damageable) player.getInventory().getItemInMainHand().getItemMeta();
                //handle durability enchantment with magic values that dont infinitely scale cuz im lazy
                if (player.getInventory().getItemInMainHand().containsEnchantment(org.bukkit.enchantments.Enchantment.DURABILITY)) {
                    int chance = player.getInventory().getItemInMainHand().getEnchantmentLevel(org.bukkit.enchantments.Enchantment.DURABILITY);
                    if (chance == 1) {
                        if (Math.random() < 0.33) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            player.getInventory().getItemInMainHand().setItemMeta((ItemMeta) damageable);
                        }
                    }
                    if (chance == 2) {
                        if (Math.random() < 0.66) {
                            damageable.setDamage(damageable.getDamage() + 1);
                            player.getInventory().getItemInMainHand().setItemMeta((ItemMeta) damageable);
                        }
                    }
                    if (chance >= 3) {
                      if (Math.random() < .88) {
                          damageable.setDamage(damageable.getDamage() + 1);
                          player.getInventory().getItemInMainHand().setItemMeta((ItemMeta) damageable);
                      }
                    }
                }
                else {

                    damageable.setDamage(damageable.getDamage() + 1);
                    player.getInventory().getItemInMainHand().setItemMeta((ItemMeta) damageable);
                }
            }
            //if its a crop, no matter what we are cancelling the event and setting the block to air :)
            event.setCancelled(true);
            block.setType(Material.AIR);


        }

    }
}

