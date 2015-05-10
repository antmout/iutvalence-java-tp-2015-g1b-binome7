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
	/** Best score of the player. */
	private int bestScore;
	/** Current score of the player. */
	private int currentScore;

	/** Create a player with a given name. */
	public Player(String name)
	{
		this.name = name;
		this.bestScore = Integer.MAX_VALUE;
		this.currentScore = 0;
	}

	/**
	 * Get the player best score.
	 *
	 * @return bestScore
	 */
	public int getBestScore()
	{
		return this.bestScore;
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

	/** Set the player best score. */
	public void setBestScore()
	{
		if (this.currentScore < this.bestScore)
		{
			this.bestScore = this.currentScore;
		}
	}

	/**
	 * Get the player name.
	 *
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %s.", name, (bestScore == Integer.MAX_VALUE) ? "never finished yed" : bestScore);
	}

	/**
	 * Increase the player current score.
	 */
	public void increaseCurrentScore()
	{
		this.currentScore++;
	}
}
