package fr.iutvalence.ardechois.klotski;

/**
 * <b>Reversed</b> klotski grid.
 * 
 * @author chayc and moutona
 *
 */
public class ReversedKlotskiGrid extends Grid
{
	/**
	 * Default number of the <b>reversed</b> grid lines.
	 * 
	 * @value 5
	 */
	public static int LINE_NUMBER = 5;
	/**
	 * Default number of the <b>reversed</b> grid columns.
	 * 
	 * @value 4
	 */
	public static int COLUMN_NUMBER = 4;

	/** Set the <b>reversed</b> grid with default values, and the pieces with their initial position. */
	public ReversedKlotskiGrid()
	{
		super(COLUMN_NUMBER, LINE_NUMBER);

		try
		{
			createPiece(new Position(1, 3), Piece.DEFAULT_ID, 2, 2);
			createPiece(new Position(0, 0), "0", 1, 1);
			createPiece(new Position(3, 0), "1", 1, 1);
			createPiece(new Position(0, 1), "2", 1, 2);
			createPiece(new Position(3, 1), "3", 1, 2);
			createPiece(new Position(1, 2), "4", 2, 1);
			createPiece(new Position(0, 3), "5", 1, 2);
			createPiece(new Position(3, 3), "6", 1, 2);
			createPiece(new Position(1, 1), "7", 1, 1);
			createPiece(new Position(2, 1), "8", 1, 1);
		}
		catch (IncorrectIdException | OverrideOldPieceException | InvalidPieceSizeException | InvalidPiecePositionException
				| IdAlreadyUsedException e)
		{
			e.printStackTrace();
			System.err.println("Problem with piece creation.");
			System.exit(1);
		}

		objective = new Objective(new Position(1, 0), grid[1][3]);
	}
}
