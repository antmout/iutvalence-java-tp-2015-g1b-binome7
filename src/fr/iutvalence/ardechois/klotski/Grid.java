package fr.iutvalence.ardechois.klotski;

/**
 * Grid of the game.
 *
 * @author chayc et moutona
 * @version 0.04
 */
public class Grid
{
	/** Default number of the grid columns. */
	public static final int DEFAULT_COLUMNS_NUMBER = 10;
	/** Default number of the grid lines. */
	public static final int DEFAULT_LINES_NUMBER = 10;

	/** Set of Compartment that create the game grid. */
	private final Piece[][] grid;

	/** Number of the grid lines. */
	private final int lineNumber;
	/** Number of the grid columns. */
	private final int columnNumber;

	/** Set the grid with default values. */
	public Grid()
	{
		this(Grid.DEFAULT_COLUMNS_NUMBER, Grid.DEFAULT_LINES_NUMBER);
	}

	/**
	 * Set the grid with given column and line numbers.
	 */
	public Grid(int columnNumber, int lineNumber)
	{
		this.columnNumber = columnNumber;
		this.lineNumber = lineNumber;

		this.grid = new Piece[this.columnNumber][this.lineNumber];

		try
		{
			createPiece(new Position(1, 0), "@", 2, 2);
			createPiece(new Position(0, 0), "0", 1, 2);
			createPiece(new Position(3, 0), "1", 1, 2);
			createPiece(new Position(0, 2), "2", 1, 2);
			createPiece(new Position(3, 2), "3", 1, 2);
			createPiece(new Position(1, 2), "4", 2, 1);
			createPiece(new Position(1, 3), "5",  1,  1);
			createPiece(new Position(2, 3), "6",  1,  1);
			createPiece(new Position(0, 4), "7",  1,  1);
			createPiece(new Position(3, 4), "8",  1,  1);
		} catch (INCORRECT_ID e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OVERRIDE_OLD_PIECE e)
		{
			e.printStackTrace();
		} catch (INVALID_PIECE_SIZE e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (INVALID_PIECE_POSITION e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ID_ALREADY_USED e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String toString()
	{
		StringBuilder gridStringBuf = new StringBuilder();
		for (int lineIndex = 0; lineIndex < lineNumber; lineIndex++)
		{
			// Create each line with the top and the center.
			// The bottom of a line is the top of the next one.
			for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++)
			{
				gridStringBuf.append("|---");
			}
			gridStringBuf.append("|\n");
			for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++)
			{
				if (grid[columnIndex][lineIndex] == null)
					gridStringBuf.append("|   ");
				else
					gridStringBuf.append("| " + grid[columnIndex][lineIndex].getId() + " ");
			}
			gridStringBuf.append("|\n");
		}

		// Close the last line.
		for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++)
		{
			gridStringBuf.append("|---");
		}
		gridStringBuf.append("|");

		return gridStringBuf.toString();
	}

	/**
	 * Create a piece with its left up position and its size.
	 * 
	 * @param leftUpPosition
	 * @param pieceId
	 * @param width
	 * @param height
	 * @throws INCORRECT_ID
	 * @throws OVERRIDE_OLD_PIECE
	 * @throws INVALID_PIECE_SIZE
	 * @throws INVALID_PIECE_POSITION
	 * @throws ID_ALREADY_USED 
	 */
	public void createPiece(Position leftUpPosition, String pieceId, int width, int height) throws INCORRECT_ID, OVERRIDE_OLD_PIECE,
			INVALID_PIECE_SIZE, INVALID_PIECE_POSITION, ID_ALREADY_USED
	{
		if (width < 0 || height < 0 || width > this.columnNumber || height > this.lineNumber)
			throw new INVALID_PIECE_SIZE();

		if (leftUpPosition.getX() < 0 || leftUpPosition.getY() < 0 || leftUpPosition.getX() + width > this.columnNumber
				|| leftUpPosition.getY() + height > this.lineNumber)
			throw new INVALID_PIECE_POSITION();
		
		if(alreadyExistingPieceId(pieceId))
			throw new ID_ALREADY_USED();

		Piece newCreatedPiece = new Piece(width, height, pieceId);

		for (int lineIndex = 0; lineIndex < newCreatedPiece.width; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < newCreatedPiece.height; columnIndex++)
			{
				if (grid[leftUpPosition.getX() + lineIndex][leftUpPosition.getY() + columnIndex] != null)
					throw new OVERRIDE_OLD_PIECE();

				grid[leftUpPosition.getX() + lineIndex][leftUpPosition.getY() + columnIndex] = newCreatedPiece;
			}
		}
	}
	
	private boolean alreadyExistingPieceId(String id)
	{
		for(int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for(int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				if(grid[columnIndex][lineIndex] != null)
					if(grid[columnIndex][lineIndex].getId() == id)
						return true;
			}
		}
		
		return false;
	}
}
