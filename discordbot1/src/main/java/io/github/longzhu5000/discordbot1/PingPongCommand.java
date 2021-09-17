package io.github.longzhu5000.discordbot1;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingPongCommand implements ICommand {
	String message = null;

	@Override
	public void run(String[] args, MessageReceivedEvent event) {

		// event.getChannel().sendMessage("`Pong!`").queue();
		/*
		 * EmbedBuilder build = new EmbedBuilder(); long time =
		 * System.currentTimeMillis(); build.setColor(Color.red);
		 * build.addField("==============================", "Pong! " + "|" + " Speed: "
		 * + (System.currentTimeMillis() - time) + " ms", false); build.build();
		 * event.getChannel().sendMessage(build.build()).queue();
		 */

		
		Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                   .queue(response /* => Message */ -> {
                       response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                   });
        }
		 
		/*
		 * EmbedBuilder build = new EmbedBuilder(); long initialTime =
		 * System.currentTimeMillis(); build.addField("Pong!", value, inline)
		 */
		
	}

	@Override
	public String getName() {
		return "ping";
	}

}
