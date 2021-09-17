package io.github.longzhu5000.discordbot1;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommand {
	public void run(String[] args, MessageReceivedEvent event);
	public String getName();
}
