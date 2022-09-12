package com.lusionmc.privatemessage.commands;

import com.lusionmc.privatemessage.PrivateMessage;
import jdk.javadoc.internal.tool.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.UUID;

public class ReplyCommand implements CommandExecutor {

    private PrivateMessage main;


    public ReplyCommand(PrivateMessage main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //   /reply [message]

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length >= 1) {
                if(main.getRecentMessages().containsKey(player.getUniqueId())) {

                    UUID uuid = main.getRecentMessages().get(player.getUniqueId());
                    if (Bukkit.getPlayer(uuid) != null) {
                        Player target = Bukkit.getPlayer(uuid);

                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < args.length; i++) {
                            builder.append(args[i]).append(" ");
                        }
                        // You -> [player]: [message]
                        // [player] -> You: [message]
                        player.sendMessage(Color.CYAN + "Hoooked" + Color.DARK_GRAY+ " • " + Color.ORANGE + "You " + Color.GRAY + "-> " + Color.ORANGE + target.getName() + Color.GRAY + ": " + Color.WHITE + builder);
                        target.sendMessage(Color.CYAN + "Hoooked" + Color.DARK_GRAY + " • " + Color.ORANGE + player.getName() + Color.GRAY + " -> " + Color.ORANGE + "You" + Color.GRAY + ": " + Color.WHITE + builder);


                    } else {
                        player.sendMessage(Color.RED + "ERROR " + Color.DARK_GRAY + "The player you messaged has gone offline!");
                    }
                } else{
                    player.sendMessage(Color.RED + "ERROR " + Color.DARK_GRAY + "You have not messaged anyone recently!");
                }
            } else {

                player.sendMessage(Color.RED + "ERROR " + Color.DARK_GRAY + "Invalid usage! Please use /reply <message>");

            }

        }

        return false;
    }
}
