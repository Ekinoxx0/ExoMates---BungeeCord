package com.ExoMates.BungeeCord.Events;

import com.ExoMates.BungeeCord.API;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class PostLogin implements Listener{
	
	@EventHandler
    public void onPostLogin(PostLoginEvent e) {
		ProxiedPlayer pp = e.getPlayer();
		
		pp.connect(API.MainHub);
		pp.sendMessage(new TextComponent(API.MessageGO + "§9Bienvenue sur " + API.ServerName + " !"));
		
    }
	
}
