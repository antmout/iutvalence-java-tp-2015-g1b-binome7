package fr.iutvalence.ardechois.klotski;

/**
 * Piece that the player can move.
 * 
 * @author chayc
 * @version 0.04
 */
public class Piece
{
	public static final int ID_LENGHT = 1;

	/** Width of the piece. */
	public final int width;
	/** Height of the piece. */
	public final int height;
	
	/** Unique Id of a piece. */
	private final String id;
	
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
	 * Get the piece id.
	 * 
	 * @return id
	 */
	public String getId()
	{
		return id;
	}
}
