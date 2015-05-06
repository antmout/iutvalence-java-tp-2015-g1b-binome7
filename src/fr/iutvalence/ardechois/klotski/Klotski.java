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
	 * @throws InvalidGridTypeException 
	 */
	public Klotski(String playerName, String gridType) throws InvalidGridTypeException
	{
		player = new Player(playerName);
		
		switch(gridType)
		{
			case "B": grid = new BasicKlotskiGrid();
				break;
				
			case "D": grid = new DoubleKlotskiGrid();
				break;
				
			case "R": grid = new ReversedKlotskiGrid();
				break;
				
			default:
				throw new InvalidGridTypeException();
		}
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
		
		while (grid.hasWin() == false)
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
		
		if(grid.hasWin())
		{
			player.setBestScore();
			System.out.println("Well play: you have beat the game! Your score is " + player.getCurrentScore() + " and your best score is " + player.getBestScore());
		}
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
