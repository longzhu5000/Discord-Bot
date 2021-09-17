package io.github.longzhu5000.discordbot1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class DiscordBot {
	private static ShardManager jda;
	public static void main(String args[]) {
		Properties prop = new Properties();
		try {
		FileInputStream ip = new FileInputStream("C:\\Users\\steve\\Documents\\ConfigFiles\\config.properties");
		prop.load(ip);
		ip.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			jda = DefaultShardManagerBuilder.createDefault(prop.getProperty("token")).setMaxReconnectDelay(32).build();
		} catch (LoginException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		jda.setActivity(Activity.watching("commands with prefix \".\" | .help"));
		jda.addEventListener(new MessageListener());
		initializeCommands();
		
	}
	public static void initializeCommands()
	{
		CommandManager.addCommand(new ArknightsCommand());
		CommandManager.addCommand(new HelpCommand());
		CommandManager.addCommand(new PingPongCommand());
		CommandManager.addCommand(new MineSweeper());
	}

}
