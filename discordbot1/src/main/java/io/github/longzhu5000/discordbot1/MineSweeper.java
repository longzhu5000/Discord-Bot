package io.github.longzhu5000.discordbot1;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MineSweeper implements ICommand {
	int size = 5;
	//int numBombs;
	String[][] gameBoard;
	String output = "";

	public void generateBoard(int s) {
		gameBoard = new String[s][s];
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				gameBoard[i][j] = "||:zero:||";
			}
		}
	}

	public String toString() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output = output + gameBoard[i][j];
			}
			output = output + "\n";
		}
		return output;
	}

	public void generateBombs(int nb) {
		int w = 0;
		int h = 0;
		for (int i = 0; i < nb; i++) {
			w = (int) (Math.random() * size);
			h = (int) (Math.random() * size);
			if (!gameBoard[w][h].equals("||:bomb:||")) {
				gameBoard[w][h] = "||:bomb:||";
			} else {
				nb++;
			}
		}

	}

	public void calculateAdjacentBombs() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int counter = 0;
				if (gameBoard[i][j].equals("||:bomb:||")) {
					continue;
				}
				try {
					if (gameBoard[i - 1][j - 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i - 1][j].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i - 1][j + 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i][j - 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i][j + 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i + 1][j - 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i + 1][j].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}
				try {
					if (gameBoard[i + 1][j + 1].equals("||:bomb:||")) {
						counter++;
					}
				} catch (Exception e) {
					
				}

				switch (counter) {
				case 1:
					gameBoard[i][j] = "||:one:||";
					break;
				case 2:
					gameBoard[i][j] = "||:two:||";
					break;
				case 3:
					gameBoard[i][j] = "||:three:||";
					break;
				case 4:
					gameBoard[i][j] = "||:four:||";
					break;
				case 5:
					gameBoard[i][j] = "||:five:||";
					break;
				case 6:
					gameBoard[i][j] = "||:six:||";
					break;
				case 7:
					gameBoard[i][j] = "||:seven:||";
					break;
				case 8:
					gameBoard[i][j] = "||:eight:||";
					break;

				}
			}
		}
	}

	public void peek() {
		int w = (int) (Math.random() * size);
		int h = (int) (Math.random() * size);
		if (gameBoard[w][h].equals("||:zero:||")) {
			gameBoard[w][h] = gameBoard[w][h].substring(2, gameBoard[w][h].length() - 2);
		} else {
			peek();
		}
	}

	@Override
	public void run(String[] args, MessageReceivedEvent event) {
		
		EmbedBuilder build = new EmbedBuilder();
		
		if (args.length == 0) {
			generateBoard(5);
		} else {
			// need try catch for string secondary input
			size = Integer.parseInt(args[0]);
			if (size > 9 || size < 5) {
				event.getChannel().sendMessage("Size cannot be more than 9 or less than 5!").queue();
				return;
			}
			generateBoard(size);
		}

		generateBombs(size);
		calculateAdjacentBombs();
		peek();
		
		build.setColor(Color.RED);
		build.setTitle("Minesweeper");
		build.addField(size + " x " + size, "Number of bombs: " + size + "\n" + toString(), false);
		build.build();
		event.getChannel().sendMessage(build.build()).queue();

		//event.getChannel().sendMessage(toString()).queue();
		output = "";
	}

	@Override
	public String getName() {
		return "minesweeper";
	}

}
