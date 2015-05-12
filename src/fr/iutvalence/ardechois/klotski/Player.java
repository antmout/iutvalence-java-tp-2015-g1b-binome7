package fr.iutvalence.ardechois.klotski;

/**
 * Player that is currently playing the game.
 *
 * @author chayc
 */
public class Player
{
	/** Name of the player. */
	private final String name;
	/** Current score of the player. */
	private int currentScore;

	/** Create a player with a given name. */
	public Player(String name)
	{
		this.name = name;
		this.currentScore = 0;
	}

	/**
	 * Get the player current score.
	 * 
	 * @return bestScore
	 */
	public int getCurrentScore()
	{
		return this.currentScore;
	}


	@Override
	public String toString()
	{
		return String.format("Player: %s.", this.name);
	}

	/**
	 * Increase the player current score.
	 */
	public void increaseCurrentScore()
	{
		this.currentScore++;
	}
}
