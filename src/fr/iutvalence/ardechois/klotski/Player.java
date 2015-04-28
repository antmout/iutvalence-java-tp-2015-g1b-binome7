package fr.iutvalence.ardechois.klotski;

/**
 * Player that is currently playing the game.
 *
 * @author chayc
 * @version 0.04
 */
public class Player
{
	/** Name of the player. */
	private final String name;
	/** Best score of the player. */
	private int bestScore;

	/** Create a player with a given name. */
	public Player(String name)
	{
		this.name = name;
		this.bestScore = Integer.MAX_VALUE;
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

	/** Set the player best score. */
	public void setBestScore(int bestScore) throws NegativeScore
	{
		if (bestScore < 0)
			throw new NegativeScore();

		if (bestScore < this.bestScore)
		{
			this.bestScore = bestScore;
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
}
