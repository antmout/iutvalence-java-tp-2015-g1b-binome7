package fr.iutvalence.ardechois.klotski;

/**
 * Player that is currently playing the game.
 * 
 * @author chayc
 * @version 0.04
 */
public class Player
{
	/**
	 * Default score : max integer that Java can handle.
	 */
	public static final int DEFAULT_BEST_SCORE = Integer.MAX_VALUE;

	/** Name of the player. */
	private final String name;
	/** Best score of the player. */
	private int bestScore;

	/** Create a player with a given name. */
	public Player(String name)
	{
		this.name = name;
		this.bestScore = DEFAULT_BEST_SCORE;
	}

	/** Get the player best score. */
	public int getBestScore()
	{
		return this.bestScore;
	}

	/** Set the player best score. */
	public void setBestScore(int bestScore)
	{
		if (bestScore < this.bestScore)
			this.bestScore = bestScore;
	}

	/** Get the player name. */
	public String getName()
	{
		return name;
	}
}
