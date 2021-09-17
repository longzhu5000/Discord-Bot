package io.github.longzhu5000.discordbot1;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand implements ICommand {

	@Override
	public void run(String[] args, MessageReceivedEvent event) {

		EmbedBuilder build = new EmbedBuilder();
		build.setColor(Color.blue);
		build.setTitle("Help:");
		build.setDescription("List of commands for stevenbotX. \n Not case sensitive"); 
		
		build.addField("Arknight Commands:", "`news` | URL for Arknights news \n`summon_simulator` | URL for summon simulator", false);
		build.addField("Other:", "`ping` | Replies with the ping in ms \n `minesweeper x` | generates a game of minesweeper with \"x\" amount of bombs", false);
		build.setThumbnail("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7q7NlmAB2tYrUeY2sWu6kQrYRmDIJbDWTeQ&usqp=CAU");
		build.build();
		event.getChannel().sendMessage(build.build()).queue();

		return;
	}

	@Override
	public String getName() {
		return "help";
	}

}
