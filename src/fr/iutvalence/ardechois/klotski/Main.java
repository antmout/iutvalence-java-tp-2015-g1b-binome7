package fr.iutvalence.ardechois.klotski;

/**
 * Allow to launch the application.
 * 
 * @author chayc
 * @version 0.04
 */
public class Main
{
	private Main()
	{
		// not called
	}

	/** Main method, start of the application. 
	 * @throws IncorrectDirectionException 
	 * @throws ImpossibleMovementException 
	 * @throws IncorrectIdException */
	public static void main(String[] args) throws IncorrectDirectionException, IncorrectIdException, ImpossibleMovementException
	{
		Klotski game = new Klotski("Player");
		game.start();
	}
}

