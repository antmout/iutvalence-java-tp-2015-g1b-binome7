package fr.iutvalence.ardechois.klotski;

/**
 * Game class, launch the game with start.
 * 
 * @author chayc
 * @version 0.03
 */
public class Klotski
{
	/** Player of the game. */
	private final Player player;
	/** Grid of the game. */
	private final Grid grid;

	/**
	 * Create a new game.
	 */
	public Klotski()
	{
		player = new Player();
		grid = new Grid();
	}

	/**
	 * Launch the game.
	 */
	public void start()
	{
		System.out.println(grid);
	}
}
