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
		Command currentCommand = new Command("8", "LEFT");
		while (true)
		{
			clearConsole();

			System.out.println(player);
			System.out.println(grid);

			System.out.print("Which piece to move: ");
			currentCommand.idPiece = commandScanner.nextLine();
			System.out.println(currentCommand.getIdPieceCommand());

			System.out.print("Which direction to move: ");
			currentCommand.direction = commandScanner.nextLine();
			System.out.println(currentCommand.getDirectionCommand());

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
	private void executeCommand(Command command)
	{
		// TODO : treat the command.

		try
		{
			this.grid.movePiece(command.getIdPieceCommand(), command.getDirectionCommand());
		}
		catch (IncorrectDirectionException e)
		{
			System.out.println("Incorrect Direction");
		}
		catch (IncorrectIdException e)
		{
			System.out.println("Incorrect Id");
		}
		catch (ImpossibleMovementException e)
		{
			System.out.println("Impossible movement");
		}

	}
}
