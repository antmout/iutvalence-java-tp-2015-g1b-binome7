package fr.iutvalence.ardechois.klotski;

/**
 * Player objective, where the klotski have to go.
 * @author moutona
 *
 */
public class Objective
{
	/**
	 * Left up position of the objective.
	 */
	private final Position leftUpPosition;
	/**
	 * Width of the objective.
	 */
	private final int width;
	/**
	 * Height of the objective.
	 */
	private final int height;
	
	/**
	 * Set the objective position and size.
	 * @param leftUpPosition
	 * @param klotskiPiece
	 */
	public Objective(Position leftUpPosition, Piece klotskiPiece)
	{
		this.leftUpPosition = leftUpPosition;
		this.width = klotskiPiece.width;
		this.height = klotskiPiece.height;
	}

	public Position getLeftUpPosition()
	{
		return this.leftUpPosition;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}
}
