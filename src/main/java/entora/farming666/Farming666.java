package entora.farming666;

import entora.farming666.commands.ModCommand;
import entora.farming666.commands.TrampleCommand;
import entora.farming666.commands.canTrampleCommand;
import entora.farming666.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Farming666 extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
//Register the listeners and commands

        getServer().getPluginManager().registerEvents(new CropPistonListener(), this);
        getServer().getPluginManager().registerEvents(new CropWaterBreakListener(), this);
        getServer().getPluginManager().registerEvents(new CropTrampleListener(), this);
        getServer().getPluginManager().registerEvents(new CropBreakListener(), this);
        getServer().getPluginManager().registerEvents(new UnderCropListener(), this);
        getCommand("trample").setExecutor(new TrampleCommand());
        getCommand("modtrample").setExecutor(new ModCommand());
        getCommand("cantrample").setExecutor(new canTrampleCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
