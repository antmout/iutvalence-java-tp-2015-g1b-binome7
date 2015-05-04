package fr.iutvalence.ardechois.klotski;

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
	 * 
	 * @throws IncorrectDirectionException
	 * @throws ImpossibleMovementException
	 * @throws IncorrectIdException
	 */

	public void start()
	{
		@SuppressWarnings("resource")
		Scanner commandScanner = new Scanner(System.in);
		Command currentCommand = new Command();

		// TODO : score
		while (true)
		{
			clearConsole();

			System.out.println(player);
			System.out.println(grid);

			System.out.print("Which piece to move: ");
			currentCommand.idPiece = commandScanner.nextLine();

			System.out.print("Which direction to choose: ");
			currentCommand.direction = commandScanner.nextLine().toUpperCase();

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
	 *
	 */
	private void executeCommand(Command command)
	{
		try
		{
			this.grid.movePiece(command.getIdPieceCommand(), command.getDirectionCommand());
			System.out.println();
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
