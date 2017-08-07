package com.ExoMates.BungeeCord.Events;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ExoMates.BungeeCord.API;

import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPing implements Listener{
	
	private void changeMOTD(ServerPing ping, String MOTDName){
		ping.setDescription(MOTDName);
	}
	
	private void changeProtocol(ServerPing ping, String ProtocolName, boolean Valid){
		ping.getVersion().setName(ProtocolName);
		if(!Valid){
			ping.getVersion().setProtocol(999);
		}
	}
	
	
	@EventHandler
	public void onProxyPing(ProxyPingEvent e){
        ServerPing ping = e.getResponse();
        ping.getPlayers().setOnline(ping.getPlayers().getOnline());
        ping.getPlayers().setMax(1000);
        
        try{
	        ping.setFavicon(Favicon.create(ImageIO.read(new File("server-icon.png"))));
		}catch(IOException ex){}
        

    	changeProtocol(ping, API.ServerPlatformName, true);
    	changeMOTD(ping,
        		"                      §1§l》 §9§l" + API.ServerName + " §1§l《"
        		+ "\n                    §c Maintenance");
		
    	
        e.setResponse(ping);
	}
	
}
