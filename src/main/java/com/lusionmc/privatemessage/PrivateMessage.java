package com.lusionmc.privatemessage;

import com.lusionmc.privatemessage.commands.MessageCommand;
import com.lusionmc.privatemessage.commands.ReplyCommand;
import com.lusionmc.privatemessage.commands.MessageCommand;
import com.lusionmc.privatemessage.commands.ReplyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class PrivateMessage extends JavaPlugin implements Listener {

    private HashMap<UUID, UUID> recentMessages;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("#         #     #     #     #          #");
        System.out.println("# #     # #     #     #     # #      # #");
        System.out.println("#  #   #  #     #     #     #  #    #  #");
        System.out.println("#   # #   #     #######     #   #  #   #");
        System.out.println("#    #    #     #     #     #    #     #");
        System.out.println("#         #     #     #     #          #");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Minehut Messaging Has Been Enabled!");
        System.out.println("For any help, contact Dylann#7762");
        getCommand("message").setExecutor(new MessageCommand(this));
        getCommand("reply").setExecutor(new ReplyCommand(this));

        recentMessages = new HashMap<>();

    }

    public HashMap<UUID, UUID> getRecentMessages() { return recentMessages; }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("#         #     #     #     #          #");
        System.out.println("# #     # #     #     #     # #      # #");
        System.out.println("#  #   #  #     #     #     #  #    #  #");
        System.out.println("#   # #   #     #######     #   #  #   #");
        System.out.println("#    #    #     #     #     #    #     #");
        System.out.println("#         #     #     #     #          #");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Minehut Messaging Has Been Disabled!");
        System.out.println("For any help, contact Dylann#7762");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Bukkit.getPluginManager().registerEvents(this, this);

        recentMessages.remove(e.getPlayer().getUniqueId());

    }


}
