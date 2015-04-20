package fr.iutvalence.ardechois.klotski;

/**
 * Player that is currently playing the game.
 * 
 * @author chayc
 * @version 0.03
 */
public class Player
{
	/* TODO Should not be here. */
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

	// TODO Use the second constructor to express this one.
	/** Create a player with the default player name and a default score. */
	public Player()
	{
		this.name = DEFAULT_PLAYER_NAME;
		this.bestScore = DEFAULT_BEST_SCORE;
	}

	/** Create a player with a given name. */
	public Player(String name)
	{
		this.name = name;
		// bestScore is not initialized?
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
