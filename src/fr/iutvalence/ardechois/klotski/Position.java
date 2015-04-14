package fr.iutvalence.ardechois.klotski;

/**
 * Position of an object.
 * 
 * @author chayc
 * @version 0.03
 */
public class Position
{
	/** Default x position. */
	public static final int DEFAULT_X = 0;
	/** Default y position. */
	public static final int DEFAULT_Y = 0;

	/** X of the position. */
	private final int x;
	/** Y of the position. */
	private final int y;

	/**
	 * Create a position with default x and y.
	 */
	public Position()
	{
		this(DEFAULT_X, DEFAULT_Y);
	}

	/**
	 * Create a position with given x and y.
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Get x of the position.
	 * 
	 * @return x
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * Get y of the position.
	 * 
	 * @return y
	 */
	public int getY()
	{
		return this.y;
	}

}
