package fr.iutvalence.ardechois.klotski.model;

import fr.iutvalence.ardechois.klotski.exceptions.IncorrectIdException;

/**
 * Piece that the player can move.
 * 
 * @author chayc
 */
class Piece
{
	/**
	 * Lenght that the piece id has to be.
	 */
	public static final int ID_LENGHT = 1;
	/**
	 * Default id of the <b>Klotski</b>.
	 */
	public static final String DEFAULT_ID = "@";

	/** Width of the piece. */
	public final int width;
	/** Height of the piece. */
	public final int height;

	/** Unique Id of a piece. */
	private final String id;

	/**
	 * Create a piece with given width and height and id.
	 * 
	 * @param width
	 * @param height
	 * @param id
	 * @throws IncorrectIdException
	 */
	public Piece(int width, int height, String id) throws IncorrectIdException
	{
		if (id.length() != Piece.ID_LENGHT)
		{
			throw new IncorrectIdException();
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
