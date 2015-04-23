package fr.iutvalence.ardechois.klotski;

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
		Klotski game = new Klotski("Player");
		game.start();
	}
}
