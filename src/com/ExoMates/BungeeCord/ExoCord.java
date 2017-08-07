package com.ExoMates.BungeeCord;

import java.net.InetSocketAddress;

import net.md_5.bungee.BungeeServerInfo;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

import com.ExoMates.BungeeCord.Events.PostLogin;
import com.ExoMates.BungeeCord.Events.ProxyPing;

@SuppressWarnings("deprecation")
public class ExoCord extends Plugin{
	
	public static Plugin plugin;
	private CommandSender cs = ProxyServer.getInstance().getConsole();
	
	@Override
	public void onEnable() {
		cs.sendMessage("+------------------ BungeeCord -------------------+");
		cs.sendMessage("|             Plugin créé par Ekinoxx             |");
		cs.sendMessage("+-------------------------------------------------+");
		plugin = this;
		
		registerCommands();
		registerEvents();
		registerServers();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
	private void registerEvents(){
		PluginManager pm = ProxyServer.getInstance().getPluginManager();
		pm.registerListener(this, new ProxyPing());
		pm.registerListener(this, new PostLogin());
	}
	
	private void registerCommands(){
		//PluginManager pm = ProxyServer.getInstance().getPluginManager();
		//pm.registerCommand(this, new mute("mute"));
	}
	
	private void registerServers(){
		cs.sendMessage(ChatColor.BLUE + "Vérification des serveurs...");
		ProxyServer.getInstance().getServers().clear();
		
		cs.sendMessage(ChatColor.YELLOW + "Enregistrement du Serveur : " + ChatColor.GREEN + "HUB");
		API.MainHub = registerServer("HUB-1", "localhost", 20001, "null" , false);
		cs.sendMessage(ChatColor.YELLOW + "Enregistrement du Serveur : " + ChatColor.GREEN + "GAME");
		API.MainGame = registerServer("GAME-1", "localhost", 20101, "null" , false);
		
		cs.sendMessage(ChatColor.GREEN + "Vérification des serveurs terminée !");
	}
	
	public static ServerInfo registerServer(String name, String ip, int port, String motd, boolean restricted){
		InetSocketAddress inetadresse = new InetSocketAddress(ip, port);
		ServerInfo serverInfo = new BungeeServerInfo(name, inetadresse, motd, restricted);
		ProxyServer.getInstance().getServers().put(serverInfo.getName(), serverInfo);
		return serverInfo;
	}
	
	
}
