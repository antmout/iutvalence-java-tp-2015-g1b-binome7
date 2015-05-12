package fr.iutvalence.ardechois.klotski;

import java.util.Scanner;
import fr.iutvalence.ardechois.klotski.exceptions.InvalidGridTypeException;

/**
 * Allow to launch the application.
 *
 * @author chayc
 */
public class GameLauncher
{
	/** Private constructor. */
	private GameLauncher()
	{ /* CAN'T HAPPEN */
	}

	/**
	 * Main method, start of the application.
	 */
	public static void main(String[] args)
	{
		Scanner playerScanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String playerName = playerScanner.nextLine();
		
		System.out.print("Enter the grid type you want (B: basic, D: double, R: reversed): ");
		String gridType = playerScanner.nextLine();

		try
		{
			Klotski game;
			
			switch(gridType)
			{
				case "B":
				case "b":
					game = new Klotski(playerName, GridTypes.BASIC);
					break;
				case "D":
				case "d":
					game = new Klotski(playerName, GridTypes.DOUBLE);
					break;
				case "R":
				case "r":
					game = new Klotski(playerName, GridTypes.REVERSED);
					break;
				default:
					playerScanner.close();
					throw new InvalidGridTypeException();
			}
			
			game.start();
			playerScanner.close();
		}
		catch (InvalidGridTypeException e)
		{
			System.err.println("Invalid grid type.");
			System.exit(1);
		}
	}
}
