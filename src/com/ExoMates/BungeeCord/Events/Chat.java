package com.ExoMates.BungeeCord.Events;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.event.EventHandler;

public class Chat {
	
	@EventHandler
	public void onPlayerChat(ChatEvent e) {
		if (!(e.getSender() instanceof ProxiedPlayer)) {
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) e.getSender();		
		if (e.getMessage().startsWith(":")) {
			e.setCancelled(true);
			for(ProxiedPlayer APP : BungeeCord.getInstance().getPlayers()){
				APP.sendMessage(new TextComponent("§e§oStaff §r§7➠ §r§3" + player.getName() + "§r§f> §r§7" + e.getMessage().substring(1, e.getMessage().length()).replace(" ", "§7 §7")));		
			}
				
		}
	}
	
}
