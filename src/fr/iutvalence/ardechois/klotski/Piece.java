package fr.iutvalence.ardechois.klotski;

/**
 * Piece that the player can move.
 * 
 * @author chayc
 * @version 0.04
 */
public class Piece
{
	/** Default width of a piece. */
	public static final int DEFAULT_WIDTH = 1;
	/** Default height of a piece. */
	public static final int DEFAULT_HEIGHT = 1;
	
	public static final int ID_LENGHT = 1;

	/** Width of the piece. */
	private final int width;
	/** Height of the piece. */
	private final int height;
	
	/** Unique Id of a piece. */
	private final String id;

	/**
	 * Create a piece with default width and height and a given id.
	 * @param id
	 * @throws INCORRECT_ID
	 */
	public Piece(String id) throws INCORRECT_ID
	{
		this(Piece.DEFAULT_WIDTH, Piece.DEFAULT_HEIGHT, id);
		// TODO : maybe remove this constructor, we always set the width and height.
	}
	
	/**
	 * Create a piece with given width and height and id.
	 * @param width
	 * @param height
	 * @param id
	 * @throws INCORRECT_ID
	 */
	public Piece(int width, int height, String id) throws INCORRECT_ID
	{
		if(id.length() != Piece.ID_LENGHT)
		{
			throw new INCORRECT_ID();
		}
		
		this.id = id;
		this.width = width;
		this.height = height;
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

	/**
	 * Get the piece id.
	 * 
	 * @return id
	 */
	public String getId()
	{
		return id;
	}
}
