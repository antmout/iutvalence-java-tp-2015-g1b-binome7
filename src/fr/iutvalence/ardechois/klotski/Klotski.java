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
		/* TODO Why "Player"??? */
		player = new Player("Player");
		grid = new Grid();
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
