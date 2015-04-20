package fr.iutvalence.ardechois.klotski;

/**
 * Allow to launch the application.
 * 
 * @author chayc
 * @version 0.03
 */
public class Main
{
	/* TODO Utility class should have a private constructor to be only called by their static methods. */
	/** Main method, start of the application. */
	public static void main(String[] args)
	{
		Klotski game = new Klotski();
		game.start();
	}
}
