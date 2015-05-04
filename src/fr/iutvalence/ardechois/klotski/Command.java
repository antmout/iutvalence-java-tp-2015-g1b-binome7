package fr.iutvalence.ardechois.klotski;

/**
 * Command given by the player in the Application.
 * 
 * @author antoine
 *
 */
public class Command
{
	/**
	 * Id of the piece in the given command.
	 */
	public String idPiece;

	/**
	 * Direction of the piece in the given command.
	 */
	public String direction;

	public Command()
	{
		this.idPiece = null;
		this.direction = null;
	}
	
	/**
	 * Create a new command with given id and direction.
	 * 
	 * @param idPiece
	 * @param string
	 */
	public Command(String idPiece, String string)
	{
		this.idPiece = idPiece;
		this.direction = string;
	}

	/**
	 * Get 'idPiece' of the command given by the player.
	 * 
	 * @return idPiece
	 */
	public String getIdPieceCommand()
	{
		return this.idPiece;
	}

	/**
	 * Get <b>direction</b> to be applied to the selected Piece.
	 * 
	 * @return direction
	 * @throws IncorrectDirectionException
	 */
	public Direction getDirectionCommand() throws IncorrectDirectionException
	{
		// TODO : collection: map
		switch (this.direction)
		{
			case "UP":
				return Direction.UP;

			case "DOWN" :
				return Direction.DOWN;

			case "RIGHT" :
				return Direction.RIGHT;

			case "LEFT" :
				return Direction.LEFT;

			default :
				throw new IncorrectDirectionException();
		}
	}
}
