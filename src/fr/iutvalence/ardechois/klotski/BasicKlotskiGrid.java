package fr.iutvalence.ardechois.klotski;

/**
 * 
 * @author chayc and moutona
 *
 */
public class BasicKlotskiGrid extends Grid
{
	public static int LINE_NUMBER = 5;
	public static int COLUMN_NUMBER = 4;
	
	public BasicKlotskiGrid()
	{
		super(COLUMN_NUMBER, LINE_NUMBER);

		try
		{
			createPiece(new Position(1, 0), Piece.DEFAULT_ID, 2, 2);
			createPiece(new Position(0, 0), "0", 1, 2);
			createPiece(new Position(3, 0), "1", 1, 2);
			createPiece(new Position(0, 2), "2", 1, 2);
			createPiece(new Position(3, 2), "3", 1, 2);
			createPiece(new Position(1, 2), "4", 2, 1);
			createPiece(new Position(1, 3), "5", 1, 1);
			createPiece(new Position(2, 3), "6", 1, 1);
			createPiece(new Position(0, 4), "7", 1, 1);
			createPiece(new Position(3, 4), "8", 1, 1);
		}
		catch (IncorrectIdException | OverrideOldPieceException  | InvalidPieceSizeException  | InvalidPiecePositionException  | IdAlreadyUsedException e)
		{
			e.printStackTrace();
			System.err.println("Problem with piece creation.");
			System.exit(1);
		}
		
		objective = new Objective(new Position(1, 1), grid[1][0]);
	}
}
