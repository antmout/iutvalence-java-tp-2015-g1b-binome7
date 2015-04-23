package fr.iutvalence.ardechois.klotski;

/**
 * Game class, launch the game with start.
 *
 * @author chayc
 * @version 0.04
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
	public Klotski(String playerName)
	{
		player = new Player(playerName);
		grid = new Grid(4, 5);
	}

	/**
	 * Launch the game.
	 */
	public void start()
	{
		System.out.println(player);
		System.out.println(grid);
	}
}
