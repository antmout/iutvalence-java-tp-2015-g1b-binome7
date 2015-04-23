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
	/* TODO JAVADOC. */
	private GameLauncher() { /* CAN'T HAPPEN */ }

	/** Main method, start of the application. */
	public static void main(String[] args)
	{
		String playerName;
		
		Scanner playerScanner = new Scanner(System.in);
		
		System.out.print("Entrer votre nom: ");
		playerName = playerScanner.nextLine();
		
		Klotski game = new Klotski(playerName);
		
		playerScanner.close();
		game.start();
	}
}
