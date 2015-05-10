package fr.iutvalence.ardechois.klotski;

/**
 * <b>Double</b> klotski grid.
 * 
 * @author chayc and moutona
 *
 */
public class DoubleKlotskiGrid extends Grid
{
	/**
	 * Default number of the <b>double</b> grid lines.
	 * 
	 * @value 10
	 */
	public static int LINE_NUMBER = 10;
	/**
	 * Default number of the <b>double</b> grid columns.
	 * 
	 * @value 8
	 */
	public static int COLUMN_NUMBER = 8;

	/** Set the <b>double</b> grid with default values, and the pieces with their initial position. */
	public DoubleKlotskiGrid()
	{
		super(COLUMN_NUMBER, LINE_NUMBER);

		try
		{
			createPiece(new Position(2, 0), Piece.DEFAULT_ID, 4, 4);
			createPiece(new Position(0, 0), "0", 2, 4);
			createPiece(new Position(6, 0), "1", 2, 4);
			createPiece(new Position(0, 4), "2", 2, 4);
			createPiece(new Position(6, 4), "3", 2, 4);
			createPiece(new Position(2, 4), "4", 4, 2);
			createPiece(new Position(2, 6), "5", 2, 2);
			createPiece(new Position(4, 6), "6", 2, 2);
			createPiece(new Position(0, 8), "7", 2, 2);
			createPiece(new Position(6, 8), "8", 2, 2);
		}
		catch (IncorrectIdException | OverrideOldPieceException | InvalidPieceSizeException | InvalidPiecePositionException
				| IdAlreadyUsedException e)
		{
			e.printStackTrace();
			System.err.println("Problem with piece creation.");
			System.exit(1);
		}

		objective = new Objective(new Position(2, 6), grid[2][0]);
	}
}
