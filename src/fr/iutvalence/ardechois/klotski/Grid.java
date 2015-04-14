package fr.iutvalence.ardechois.klotski;

/**
 * Grid of the game.
 *
 * @author chayc et moutona
 * @version 0.02
 */
public class Grid
{
	/** Default number of the grid columns. */
	public static final int DEFAULT_COLUMNS_NUMBER = 10;
	/** Default number of the grid lines. */
	public static final int DEFAULT_LINES_NUMBER = 10;

	/** Set of Compartment that create the game grid. */
	private final Piece[][] grid;
	
	/** Number of the grid lines.*/
	private final int lineNumber;
	/** Number of the grid columns.*/
	private final int columnNumber;

	/** Set the grid with default values. */
	public Grid()
	{
		this(Grid.DEFAULT_COLUMNS_NUMBER, Grid.DEFAULT_LINES_NUMBER);
	}

	/** Set the grid with given column and line numbers. 
	 */
	public Grid(int columnNumber, int lineNumber)
	{
		this.columnNumber = columnNumber;
		this.lineNumber = lineNumber;

		this.grid = new Piece[this.columnNumber][this.lineNumber];
		for (int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				this.grid[columnIndex][lineIndex] = null;
			}
		}
	}

	/**
	 * String representation of the grid.
	 * Using String Builder.
	 */
	@Override
	public String toString()
	{		
		String gridString = "";
		StringBuilder gridStringBuf = new StringBuilder(gridString);

		for (int lineIndex = 0; lineIndex < lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < columnNumber; columnIndex++)
			{
				gridStringBuf.append("_ ");
			}
			gridStringBuf.append("\n");
		}
		System.out.println(gridStringBuf);
		return gridString;
	}

	/**
	 * Create a piece with his left up position.
	 * 
	 * @param leftUpPosition
	 */
	public void createPiece(Position leftUpPosition)
	{
		grid[leftUpPosition.getX()][leftUpPosition.getY()] = new Piece();

	}
}
