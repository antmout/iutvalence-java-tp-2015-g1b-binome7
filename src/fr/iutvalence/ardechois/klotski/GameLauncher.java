package fr.iutvalence.ardechois.klotski;

import java.util.Scanner;

/**
 * Allow to launch the application.
 *
 * @author chayc
 * @version 0.04
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
		@SuppressWarnings("resource")
		Scanner playerScanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String playerName = playerScanner.nextLine();
		
		System.out.print("Enter the grid type you want (B: basic, D: double, R: reversed): ");
		String gridType = playerScanner.nextLine();

		try
		{
			Klotski game = new Klotski(playerName, gridType);
			game.start();
		}
		catch (InvalidGridTypeException e)
		{
			System.err.println("Invalid grid type.");
			System.exit(1);
		}
	}
}
