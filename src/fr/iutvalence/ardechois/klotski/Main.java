package fr.iutvalence.ardechois.klotski;

/**
 * Allow to launch the application.
 * 
 * @author chayc
 * @version 0.02
 */
public class Main
{
	/**
	 * Main method, start of the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Klotski game = new Klotski();
		game.start();
	}
}
