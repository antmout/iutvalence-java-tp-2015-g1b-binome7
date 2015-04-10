package fr.iutvalence.ardechois.klotski;

/**
 * Player that is currently playing the game.
 * 
 * @author chayc
 * @version 0.02
 */
public class Player
{
	/**
	 * Players that don't want name has a default player name.
	 */
	public static final String DEFAULT_PLAYER_NAME = "Player";
	/**
	 * Default score : max integer that Java can handle.
	 */
	public static final int DEFAULT_BEST_SCORE = Integer.MAX_VALUE;

	/** Name of the player. */
	private final String name;
	/** Best score of the player. */
	private int bestScore;

	/**
	 * Create a player with the default player name and a default score.
	 * 
	 * @param name
	 */
	public Player()
	{
		this.name = DEFAULT_PLAYER_NAME;
		this.bestScore = DEFAULT_BEST_SCORE;
	}

	/**
	 * Create a player with a given name.
	 * 
	 * @param name
	 */
	public Player(String name)
	{
		this.name = name;
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
	 * Set the player best score.
	 * 
	 * @param bestScore
	 */
	public void setBestScore(int bestScore)
	{
		if (bestScore < this.bestScore)
			this.bestScore = bestScore;
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
}
