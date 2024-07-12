package com.semin.mypark;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Mypark extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Mypark is enabled!");


        getServer().getPluginManager()
                .registerEvents(new MyparkEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("Closing Mypark");
    }


    @Override
    public boolean onCommand(
            @NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args
    ) {
        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("park")) {
                player.sendMessage(Component.text("hoop"));

                return true;
            }
        }

        return true;
    }
}
