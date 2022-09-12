package com.lusionmc.privatemessage.commands;

import com.lusionmc.privatemessage.PrivateMessage;
import jdk.javadoc.internal.tool.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class MessageCommand implements CommandExecutor {

    private PrivateMessage main;

    public MessageCommand(PrivateMessage main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {


            Player player = (Player) sender;

           //message [player] [message]
            if (args.length == 2) {

                if (Bukkit.getPlayerExact(args[0]) != null) {

                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (Bukkit.getPlayerExact(args[0]) == player) {

                        //     /message [player] [message]

                        StringBuilder builder = new StringBuilder();

                        for (int i = 1; i < args.length; i++) {

                            builder.append(args[i]).append(" ");

                        }
                                                                                                           // You -> [player]: [message]// [player] -> You: [message]
                        player.sendMessage(Color.CYAN + "Hoooked" + Color.DARK_GRAY+ " • " + Color.ORANGE + "You " + Color.GRAY + "-> " + Color.ORANGE + target.getName() + Color.GRAY + ": " + Color.WHITE + builder);

                        target.sendMessage(Color.CYAN + "Hoooked" + Color.DARK_GRAY + " • " + Color.ORANGE + player.getName() + Color.GRAY + " -> " + Color.ORANGE + "You" + Color.GRAY + ": " + Color.WHITE + builder);

                        main.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());

                    } else {

                        player.sendMessage(Color.RED + "ERROR" + Color.DARK_GRAY + "You cannot message yourself!");

                    }

                } else {

                    player.sendMessage(Color.RED + "ERROR " + Color.DARK_GRAY + "The player you were trying to message was not found!");

                }

            } else {

                player.sendMessage(Color.RED + "ERROR " + Color.DARK_GRAY + "Invalid Usage! Use /message <player> <message>");

            }

        }

        return false;
    }
}
