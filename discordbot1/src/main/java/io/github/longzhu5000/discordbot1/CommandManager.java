package io.github.longzhu5000.discordbot1;

import java.util.HashMap;

public class CommandManager {
	private static HashMap<String, ICommand> map = new HashMap<>();
	
	public static void addCommand(ICommand value)
	{
		map.put(value.getName().toLowerCase(), value);
	}
	
	public static ICommand getCommand(String a)
	{
		return map.get(a.toLowerCase());
	}
	

}
