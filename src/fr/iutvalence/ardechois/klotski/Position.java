package fr.iutvalence.ardechois.klotski;

/**
 * Position of an object.
 * 
 * @author chayc
 */
public class Position
{
	/** X of the position. */
	private final int x;
	/** Y of the position. */
	private final int y;

	/** Create a position with given x and y. */
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/** Get x of the position. */
	public int getX()
	{
		return this.x;
	}

	/** Get y of the position. */
	public int getY()
	{
		return this.y;
	}

}
