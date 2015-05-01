package fr.iutvalence.ardechois.klotski;

import java.io.IOException;
import java.util.Scanner;

/**
 * Game class, launch the game with start.
 *
 * @author chayc
 * @version 0.04
 */
public class Klotski
{
	/** Player of the game. */
	private final Player player;
	/** Grid of the game. */
	private final Grid grid;

	/**
	 * Create a new game.
	 */
	public Klotski(String playerName)
	{
		player = new Player(playerName);
		grid = new Grid(4, 5);
	}

	/**
	 * Launch the game.
	 */
	public void start()
	{
		Scanner commandScanner = new Scanner(System.in);
		String currentCommand;
		while (true)
		{
			clearConsole();

			System.out.println(player);
			System.out.println(grid);

			System.out.print("Which command to execute: ");
			currentCommand = commandScanner.nextLine();

			executeCommand(currentCommand);
		}

	}

	/**
	 * Clear the console.
	 */
	private void clearConsole()
	{
		// TODO : clear the console.

	}

	/**
	 * Execute the given command.
	 * 
	 * @param command
	 */
	private void executeCommand(String command)
	{
		// TODO : treat the command.

		try
		{
			this.grid.movePiece("7", Direction.RIGHT);
		}
		catch (IncorrectDirection e)
		{
			System.out.println("Incorrect Direction");
		}
		catch (IncorrectId e)
		{
			System.out.println("Incorrect Id");
		}
		catch (ImpossibleMovement e)
		{
			System.out.println("Impossible movement");
		}

	}
}
