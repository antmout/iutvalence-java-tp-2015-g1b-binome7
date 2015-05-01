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
	 * 
	 * @throws IncorrectDirectionException
	 * @throws ImpossibleMovementException 
	 * @throws IncorrectIdException 
	 */
	public static void main(String[] args) throws IncorrectDirectionException, IncorrectIdException, ImpossibleMovementException
	{
		try (Scanner playerScanner = new Scanner(System.in))
		{
			System.out.print("Entrer votre nom: ");
			String playerName = playerScanner.nextLine();

			Klotski game = new Klotski(playerName);
			game.start();
		}
	}
}
