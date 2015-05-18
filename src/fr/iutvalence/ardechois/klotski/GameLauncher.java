package fr.iutvalence.ardechois.klotski;

import java.util.Scanner;
import fr.iutvalence.ardechois.klotski.exceptions.InvalidGridTypeException;
import fr.iutvalence.ardechois.klotski.view.console.GridTypes;
import fr.iutvalence.ardechois.klotski.view.console.Klotski;

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
		consoleStarter();
	}
	
	private static void consoleStarter() {
		Scanner playerScanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String playerName = playerScanner.nextLine();
		
		System.out.print("Enter the grid type you want (B: basic, D: double, R: reversed): ");
		String gridType = playerScanner.nextLine().toUpperCase().trim();

		try
		{
			Klotski game;
			
			switch(gridType)
			{
				case "B":
					game = new Klotski(playerName, GridTypes.BASIC);
					break;
				case "D":
					game = new Klotski(playerName, GridTypes.DOUBLE);
					break;
				case "R":
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
