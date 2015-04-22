package fr.iutvalence.ardechois.klotski;

/**
 * Piece that the player can move.
 * 
 * @author chayc
 * @version 0.03
 */
public class Piece
{
	/** Default width of a piece. */
	public static final int DEFAULT_WIDTH = 1;
	/** Default height of a piece. */
	public static final int DEFAULT_HEIGHT = 1;

	/** Width of the piece. */
	private final int width;
	/** Height of the piece. */
	private final int height;

	/**
	 * Create a piece with default width and height.
	 */
	public Piece()
	{
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
	}

	/**
	 * Get the piece width.
	 * 
	 * @return width
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Get the piece height.
	 * 
	 * @return height
	 */
	public int getHeight()
	{
		return this.height;
	}
}
