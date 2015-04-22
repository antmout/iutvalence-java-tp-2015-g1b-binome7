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
		// TODO Piece putted on the grid here?
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
				// TODO Is it normal if there is not Piece#toString call here?
				gridStringBuf.append("|   ");
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

	// TODO Improve this method.
	/** Create a piece with his left up position. */
	public void createPiece(Position leftUpPosition)
	{		
		Piece newCreatedPiece = new Piece();
		
		for(int lineIndex = 0; lineIndex < newCreatedPiece.getWidth(); lineIndex++)
		{
			for(int columnIndex = 0; columnIndex < newCreatedPiece.getHeight(); columnIndex++)
			{
				grid[leftUpPosition.getX() + lineIndex][leftUpPosition.getY() + columnIndex] = newCreatedPiece;
			}
		}
	}
}
