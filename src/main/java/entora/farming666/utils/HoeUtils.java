package entora.farming666.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class HoeUtils {
    //create a method to check if the item in a given players hand is a hoe
    public static boolean isPlayerHoldingHoe(Player player) {
        //get the item in the players hand
        ItemStack item = player.getInventory().getItemInMainHand();
        //check if the item is a hoe
        //if the item is a hoe return true
        return item.getType().toString().contains("HOE");
        //if the item is not a hoe return false

    }

    //create a method to detect what type of hoe the player is holding and return it as a string
    public static ItemStack getHoeType(Player player) {
        if (isPlayerHoldingHoe(player)) {
            //get the item in the players hand
            //if its a hoe, return the item as a itemstack
            return player.getInventory().getItemInMainHand();
        }
        return null;
    }
    //create a method to check the level of the fortune enchantment on a item and return the level as an int
    public static int getFortuneLevel(ItemStack item) {
        //check if the item has the fortune enchantment
        if (item.containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
            //if the item has the fortune enchantment return the level of the enchantment as an int
            return item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }
        //if the item does not have the fortune enchantment return 0
        return 0;
    }
    //create a method to determine how many crops should be dropped based on the hoe type and fortune level
    public static int howMany(ItemStack item) {
        int fortune = getFortuneLevel(item);
        Material hoeType = item.getType();
        switch (hoeType) {
            case WOODEN_HOE:
            case STONE_HOE:
                return 1 + fortune;
            case IRON_HOE:
            case GOLDEN_HOE:
                return 2 + fortune;
            case DIAMOND_HOE:
            case NETHERITE_HOE:
                return 3 + fortune;
            default:
                return 0;
        }
    }
        //create a method to generate a random number from 1 to 3;
        public static int randomSeeds() {
            int min = 1;
            int max = 3;
            int range = max - min + 1;
            return (int) (Math.random() * range) + min;
        }
    }










