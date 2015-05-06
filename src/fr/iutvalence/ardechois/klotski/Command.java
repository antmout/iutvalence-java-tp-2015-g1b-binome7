package fr.iutvalence.ardechois.klotski;

import java.util.HashMap;

/**
 * Command given by the player in the Application.
 * 
 * @author antoine
 *
 */
public class Command
{
	/**
	 * Map of the different directions. The string direction is the key to the Direction object.
	 */
	public final HashMap<String, Direction> directionHashMap;
	
	/**
	 * Id of the piece in the given command.
	 */
	public String idPiece;

	/**
	 * Direction of the piece in the given command. Always in capital letters.
	 */
	public String direction;

	/**
	 * Create a default command (null command).
	 */
	public Command()
	{
		this(null, null);
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
		
		this.directionHashMap = new HashMap<String, Direction>();
		this.directionHashMap.put("UP", Direction.UP);
		this.directionHashMap.put("DOWN", Direction.DOWN);
		this.directionHashMap.put("LEFT", Direction.LEFT);
		this.directionHashMap.put("RIGHT", Direction.RIGHT);
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
		if(this.directionHashMap.get(this.direction) == null)
		{
			throw new IncorrectDirectionException();
		}
		
		return this.directionHashMap.get(this.direction);
	}
}
