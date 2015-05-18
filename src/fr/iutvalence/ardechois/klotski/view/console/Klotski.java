package fr.iutvalence.ardechois.klotski.view.console;

import java.util.Scanner;
import fr.iutvalence.ardechois.klotski.exceptions.ImpossibleMovementException;
import fr.iutvalence.ardechois.klotski.exceptions.IncorrectDirectionException;
import fr.iutvalence.ardechois.klotski.exceptions.IncorrectIdException;
import fr.iutvalence.ardechois.klotski.exceptions.InvalidGridTypeException;
import fr.iutvalence.ardechois.klotski.model.BasicKlotskiGrid;
import fr.iutvalence.ardechois.klotski.model.DoubleKlotskiGrid;
import fr.iutvalence.ardechois.klotski.model.Grid;
import fr.iutvalence.ardechois.klotski.model.Player;
import fr.iutvalence.ardechois.klotski.model.ReversedKlotskiGrid;

/**
 * Game class, launch the game with start.
 *
 * @author chayc
 */
public class Klotski
{
	/** Player of the game. */
	private final Player player;
	/** Grid of the game. */
	private final Grid grid;

	/**
	 * Create a new game.
	 * 
	 * @throws InvalidGridTypeException
	 */
	public Klotski(String playerName, GridTypes gridType) throws InvalidGridTypeException
	{
		player = new Player(playerName);

		switch (gridType)
		{
			case BASIC :
				grid = new BasicKlotskiGrid();
				break;

			case DOUBLE :
				grid = new DoubleKlotskiGrid();
				break;

			case REVERSED :
				grid = new ReversedKlotskiGrid();
				break;

			default :
				throw new InvalidGridTypeException();
		}
	}

	/**
	 * Launch the game.
	 */

	public void start()
	{
		Scanner commandScanner = new Scanner(System.in);
		Command currentCommand = new Command();

		while (grid.hasWon() == false)
		{
			System.out.println("---------------------------------------");
			System.out.println(player);
			System.out.println("Current score: " + player.getCurrentScore());
			System.out.println(grid);

			System.out.print("Which piece to move: ");
			currentCommand.idPiece = commandScanner.nextLine();

			System.out.print("Which direction to choose: ");
			currentCommand.direction = commandScanner.nextLine().toUpperCase();

			executeCommand(currentCommand);
			player.increaseCurrentScore();
		}

		if (grid.hasWon())
		{
			System.out.println("Well play: you have beat the game! Your score is " + player.getCurrentScore() + ".");
		}
		commandScanner.close();
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
