package io.github.longzhu5000.discordbot1;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ArknightsCommand implements ICommand {

	@Override
	public void run(String[] args, MessageReceivedEvent event) {
		if ( args.length == 0)
		{
			event.getChannel().sendMessage("`Arknight Commands: \nnews \nsummonSim`").queue();
		}
		
		switch (args[0].toLowerCase())
		{
			case "news":
				event.getChannel().sendMessage("https://gamepress.gg/arknights/").queue();
				break;
			case "summon_simulator":
				event.getChannel().sendMessage("https://gamepress.gg/arknights/").queue();
				break;
				
			default:
				event.getChannel().sendMessage("Invalid Subcommand").queue();
		}
	}

	@Override
	public String getName() {
		return "arknights";
	}

}
