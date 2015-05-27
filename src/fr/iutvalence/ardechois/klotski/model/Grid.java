package fr.iutvalence.ardechois.klotski.model;

import fr.iutvalence.ardechois.klotski.exceptions.IdAlreadyUsedException;
import fr.iutvalence.ardechois.klotski.exceptions.ImpossibleMovementException;
import fr.iutvalence.ardechois.klotski.exceptions.IncorrectIdException;
import fr.iutvalence.ardechois.klotski.exceptions.InvalidPiecePositionException;
import fr.iutvalence.ardechois.klotski.exceptions.InvalidPieceSizeException;
import fr.iutvalence.ardechois.klotski.exceptions.OverrideOldPieceException;

/**
 * Grid of the game.
 *
 * @author chayc and moutona
 */
public class Grid
{
	/** Default number of the grid columns. */
	public static final int DEFAULT_COLUMNS_NUMBER = 10;
	/** Default number of the grid lines. */
	public static final int DEFAULT_LINES_NUMBER = 10;

	/** Set of Compartment that create the game grid. */
	protected final Piece[][] grid;

	/** Number of the grid lines. */
	protected final int lineNumber;
	/** Number of the grid columns. */
	protected final int columnNumber;
	/**
	 * Objective that the player have to reach.
	 */
	protected Objective objective;

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
	}
	
	/**
	 * Get the grid line number.
	 * @return lineNumber
	 */
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	/**
	 * Get the grid column number.
	 * @return columnNumber
	 */
	public int getColumnNumber()
	{
		return this.columnNumber;
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
					gridStringBuf.append("|  ");
				else
					gridStringBuf.append("| " + grid[columnIndex][lineIndex].getId());
				
				if(columnIndex >= objective.getLeftUpPosition().getX() && columnIndex < objective.getLeftUpPosition().getX() + objective.getWidth() &&
						lineIndex >= objective.getLeftUpPosition().getY() && lineIndex < objective.getLeftUpPosition().getY() + objective.getHeight())
				{
					gridStringBuf.append("*");
				}
				else
				{
					gridStringBuf.append(" ");
				}
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
	 * @throws IncorrectIdException
	 * @throws OverrideOldPieceException
	 * @throws InvalidPieceSizeException
	 * @throws InvalidPiecePositionException
	 * @throws IdAlreadyUsedException
	 */
	public void createPiece(Position leftUpPosition, String pieceId, int width, int height) throws IncorrectIdException,
			OverrideOldPieceException, InvalidPieceSizeException, InvalidPiecePositionException, IdAlreadyUsedException
	{
		if (width < 0 || height < 0 || width > this.columnNumber || height > this.lineNumber)
			throw new InvalidPieceSizeException();

		if (leftUpPosition.getX() < 0 || leftUpPosition.getY() < 0 || leftUpPosition.getX() + width > this.columnNumber
				|| leftUpPosition.getY() + height > this.lineNumber)
			throw new InvalidPiecePositionException();

		if (isPieceIdSet(pieceId))
			throw new IdAlreadyUsedException();

		Piece newCreatedPiece = new Piece(width, height, pieceId);

		for (int lineIndex = 0; lineIndex < newCreatedPiece.width; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < newCreatedPiece.height; columnIndex++)
			{
				if (grid[leftUpPosition.getX() + lineIndex][leftUpPosition.getY() + columnIndex] != null)
					throw new OverrideOldPieceException();

				grid[leftUpPosition.getX() + lineIndex][leftUpPosition.getY() + columnIndex] = newCreatedPiece;
			}
		}
	}

	/**
	 * Return true if the piece id is used.
	 * 
	 * @param id
	 * @return exists
	 */
	private boolean isPieceIdSet(String id)
	{
		for (int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				if (grid[columnIndex][lineIndex] != null)
					if (grid[columnIndex][lineIndex].getId() == id)
						return true;
			}
		}

		return false;
	}

	/**
	 * Move the piece in the given direction.
	 * 
	 * @param pieceId
	 * @param direction
	 * @throws IncorrectIdException
	 * @throws ImpossibleMovementException
	 */
	public void movePiece(String pieceId, Direction direction) throws IncorrectIdException,
			ImpossibleMovementException
	{
		Piece pieceToMove = getPiece(pieceId);
		Position piecePosition = getPieceLeftUpPosition(pieceId);

		switch (direction)
		{
			case UP :
			{
				if (piecePosition.getY() == 0)
				{
					throw new ImpossibleMovementException();
				}

				for (int columnIndex = piecePosition.getX(); columnIndex < piecePosition.getX() + pieceToMove.width; columnIndex++)
				{
					if (this.grid[columnIndex][piecePosition.getY() - 1] != null)
					{
						throw new ImpossibleMovementException();
					}
				}

				for (int columnIndex = piecePosition.getX(); columnIndex < piecePosition.getX() + pieceToMove.width; columnIndex++)
				{
					this.grid[columnIndex][piecePosition.getY() - 1] = pieceToMove;
					this.grid[columnIndex][piecePosition.getY() + pieceToMove.height - 1] = null;
				}
				break;
			}

			case DOWN :
			{
				if (piecePosition.getY() + pieceToMove.height == this.lineNumber)
				{
					throw new ImpossibleMovementException();
				}

				for (int columnIndex = piecePosition.getX(); columnIndex < piecePosition.getX() + pieceToMove.width; columnIndex++)
				{
					if (this.grid[columnIndex][piecePosition.getY() + pieceToMove.height] != null)
					{
						throw new ImpossibleMovementException();
					}
				}
				for (int columnIndex = piecePosition.getX(); columnIndex < piecePosition.getX() + pieceToMove.width; columnIndex++)
				{
					this.grid[columnIndex][piecePosition.getY() + pieceToMove.height] = pieceToMove;
					this.grid[columnIndex][piecePosition.getY()] = null;
				}
				break;

			}

			case RIGHT :
			{
				if (piecePosition.getX() + pieceToMove.width == this.columnNumber)
				{
					throw new ImpossibleMovementException();
				}

				for (int lineIndex = piecePosition.getY(); lineIndex < piecePosition.getY() + pieceToMove.height; lineIndex++)
				{
					if (this.grid[piecePosition.getX() + pieceToMove.width][lineIndex] != null)
					{
						throw new ImpossibleMovementException();
					}
				}

				for (int lineIndex = piecePosition.getY(); lineIndex < piecePosition.getY() + pieceToMove.height; lineIndex++)
				{
					this.grid[piecePosition.getX() + pieceToMove.width][lineIndex] = pieceToMove;
					this.grid[piecePosition.getX()][lineIndex] = null;
				}

				break;
			}

			case LEFT :
			{
				if (piecePosition.getX() == 0)
				{
					throw new ImpossibleMovementException();
				}

				for (int lineIndex = piecePosition.getY(); lineIndex < piecePosition.getY() + pieceToMove.height; lineIndex++)
				{
					if (this.grid[piecePosition.getX() - 1][lineIndex] != null)
					{
						throw new ImpossibleMovementException();
					}
				}

				for (int lineIndex = piecePosition.getY(); lineIndex < piecePosition.getY() + pieceToMove.height; lineIndex++)
				{
					this.grid[piecePosition.getX() - 1][lineIndex] = pieceToMove;
					this.grid[piecePosition.getX() + pieceToMove.width - 1][lineIndex] = null;
				}

				break;
			}
		}
	}
	/**
	 * Get the piece with the given Id.
	 * 
	 * @param pieceId
	 * @return piece
	 * @throws IncorrectIdException
	 */
	private Piece getPiece(String pieceId) throws IncorrectIdException
	{
		for (int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				if (grid[columnIndex][lineIndex] != null)
				{
					if (grid[columnIndex][lineIndex].getId().equals(pieceId))
					{
						return grid[columnIndex][lineIndex];
					}
				}
			}
		}
		throw new IncorrectIdException();
	}
	
	public String getPieceId(Position pos)
	{
		if(grid[pos.getX()][pos.getY()] != null)
			return grid[pos.getX()][pos.getY()].getId();
		
		return " ";
	}
	
	/**
	 * Get the piece left up position with a given Id.
	 * 
	 * @param pieceId
	 * @return position
	 * @throws IncorrectIdException
	 */
	private Position getPieceLeftUpPosition(String pieceId) throws IncorrectIdException
	{
		for (int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				if (grid[columnIndex][lineIndex] != null)
					if (grid[columnIndex][lineIndex].getId().equals(pieceId))
						return new Position(columnIndex, lineIndex);
			}
		}

		throw new IncorrectIdException();
	}
	
	/** Return true if the klotski is on the objective. */
	public boolean hasWon()
	{
		for (int lineIndex = 0; lineIndex < this.lineNumber; lineIndex++)
		{
			for (int columnIndex = 0; columnIndex < this.columnNumber; columnIndex++)
			{
				if (grid[columnIndex][lineIndex] != null)
				{
					if(grid[columnIndex][lineIndex].getId().equals(Piece.DEFAULT_ID))
					{
						if(columnIndex < objective.getLeftUpPosition().getX() || 
								columnIndex >= objective.getLeftUpPosition().getX()+objective.getWidth() || 
								lineIndex < objective.getLeftUpPosition().getY() || 
								lineIndex >= objective.getLeftUpPosition().getY()+objective.getHeight())
						{
							return false;
						}
					}
				}		
			}
		}
		return true;
	}
}
