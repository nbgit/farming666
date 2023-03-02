package entora.farming666.utils;
//import required spigot api classes to use in a class that checks if a block is a crop, what type, and the drops

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

public class CropUtils {
    //given a block, check if the block is a wheat, potato, carrot, beetroot, or netherwart and return true if it is
    public static boolean isCrop(Block block) {
        //get the block type
        Material material = block.getType();
        //check if the block is a crop
        if (material == Material.WHEAT || material == Material.POTATOES || material == Material.CARROTS || material == Material.BEETROOTS || material == Material.NETHER_WART) {
            //if the block is a crop return true
            return true;
        }
        //if the block is not a crop return false
        return false;
    }
    //if the block is a crop, return the type of crop as a string
    public static String getCropType(Block block) {
        //get the block type
        Material material = block.getType();
        //check if the block is a crop
        if (isCrop(block)) {
            //if the block is a crop return the type of crop as a string
            String string = material.toString();
            return string;
        }
        //if the block is not a crop return null
        return null;
    }
//create a method that checks if a crop is fully grown given a bloc
    public static boolean isCropFullyGrown(Block block) {
        //get the block data
        BlockData blockData = block.getBlockData();
        //check if the block data is ageable
        if (blockData instanceof Ageable) {
            //if the block data is ageable, get the ageable data
            Ageable ageable = (Ageable) blockData;
            //check if the crop is fully grown
            if (ageable.getAge() == ageable.getMaximumAge()) {
                //if the crop is fully grown return true
                return true;
            }
        }
        //if the crop is not fully grown return false
        return false;
    }
    //create a method that returns the drops of a crop as an array of itemstacks
    public static ItemStack[] whatDrops(Block block, int amount, int seedAmount) {
        //get the block type
        Material material = block.getType();
        //check if the block is a crop
        if (isCrop(block)) {
            //if the block is a crop, check what type of crop it is
            switch (material) {
                //if the block is a wheat crop, return the correct amount of wheat and seeds
                case WHEAT:
                    ItemStack[] wheatDrops = new ItemStack[2];
                    wheatDrops[0] = new ItemStack(Material.WHEAT, amount);
                    wheatDrops[1] = new ItemStack(Material.WHEAT_SEEDS, seedAmount);
                    return wheatDrops;
                //if the block is a potato crop, return the correct amount of potatoes and seeds
                case POTATOES:
                    ItemStack[] potatoDrops = new ItemStack[2];
                    potatoDrops[0] = new ItemStack(Material.POTATO, amount);
                    potatoDrops[1] = new ItemStack(Material.POTATO, seedAmount);
                    return potatoDrops;
                //if the block is a carrot crop, return the correct amount of carrots and seeds
                case CARROTS:
                    ItemStack[] carrotDrops = new ItemStack[2];
                    carrotDrops[0] = new ItemStack(Material.CARROT, amount);
                    carrotDrops[1] = new ItemStack(Material.CARROT, seedAmount);
                    return carrotDrops;
                //if the block is a beetroot crop, return the correct amount of beetroot and seeds
                case BEETROOTS:
                    ItemStack[] beetrootDrops = new ItemStack[2];
                    beetrootDrops[0] = new ItemStack(Material.BEETROOT, amount);
                    beetrootDrops[1] = new ItemStack(Material.BEETROOT_SEEDS, seedAmount);
                    return beetrootDrops;
                //if the block is a netherwart crop, return the correct amount of netherwart and seeds
                case NETHER_WART:
                    ItemStack[] netherwartDrops = new ItemStack[2];
                    netherwartDrops[0] = new ItemStack(Material.NETHER_WART, amount);
                    netherwartDrops[1] = new ItemStack(Material.NETHER_WART, seedAmount);
                    return netherwartDrops;
            }
        }
        //if the block is not a crop, return null
        return null;
    }

}

