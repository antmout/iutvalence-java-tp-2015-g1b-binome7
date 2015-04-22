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
	
	@Override
	public String toString()
	{
		StringBuilder playerStringBuilder = new StringBuilder();
		playerStringBuilder.append(this.name + ": ");
		
		if(this.bestScore == DEFAULT_BEST_SCORE)
		{
			playerStringBuilder.append("never finished yed.");
		}
		else
		{
			playerStringBuilder.append(this.bestScore + ".");
		}
		
		return playerStringBuilder.toString();
	}
}
