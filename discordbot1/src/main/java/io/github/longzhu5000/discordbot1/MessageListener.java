package io.github.longzhu5000.discordbot1;

import java.util.Arrays;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
	public static final String prefix = ".";
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();
		if (message.startsWith(prefix))
		{
			message = message.substring(prefix.length());
			String[] array = message.split("\\s");
			ICommand command = CommandManager.getCommand(array[0]);
			if (command != null)
			{
				command.run(array.length > 1 ? Arrays.copyOfRange(array, 1, array.length) : new String[0], event);
			}
			
		}
	}

}
