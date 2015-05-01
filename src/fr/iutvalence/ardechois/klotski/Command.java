package fr.iutvalence.ardechois.klotski;

/**
 * Command given by the player in the Application.
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
	 */
	public Direction getDirectionCommand()
	{
		// Implement this getter !
		return Direction.DOWN;
	}
}
