package fr.iutvalence.ardechois.klotski;

/**
 * Player objective, where the klotski have to go.
 * 
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
	 * 
	 * @param leftUpPosition
	 * @param klotskiPiece
	 */
	public Objective(Position leftUpPosition, Piece klotskiPiece)
	{
		this.leftUpPosition = leftUpPosition;
		this.width = klotskiPiece.width;
		this.height = klotskiPiece.height;
	}

	/**
	 * Get the left up position of the objective.
	 */
	public Position getLeftUpPosition()
	{
		return this.leftUpPosition;
	}

	/**
	 * Get the objective width (should be the klotski width).
	 * 
	 * @return width
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Get the objective height (should be the klotski height).
	 * 
	 * @return height
	 */
	public int getHeight()
	{
		return this.height;
	}
}
