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
	public final int width;
	/** Height of the piece. */
	public final int height;

	/**
	 * Create a piece with default width and height.
	 */
	public Piece()
	{
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
	}
}
