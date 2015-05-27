package fr.iutvalence.ardechois.klotski.view.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.iutvalence.ardechois.klotski.model.BasicKlotskiGrid;
import fr.iutvalence.ardechois.klotski.model.DoubleKlotskiGrid;
import fr.iutvalence.ardechois.klotski.model.Grid;
import fr.iutvalence.ardechois.klotski.model.GridTypes;
import fr.iutvalence.ardechois.klotski.model.Position;
import fr.iutvalence.ardechois.klotski.model.ReversedKlotskiGrid;

public class GUIKlotski
{
	private Grid grid;

	public GUIKlotski()
	{
		JFrame menu = new JFrameMenu(this);
	}

	public void initGame(GridTypes gridType)
	{
		switch (gridType)
		{
			case BASIC: 
				grid = new BasicKlotskiGrid();
				break;
			case DOUBLE:
				grid = new DoubleKlotskiGrid();
				break;
			case REVERSED:
				grid = new ReversedKlotskiGrid();
				break;
		}
		SwingUtilities.invokeLater(new RunnableGame(gridType, grid.getColumnNumber(), grid.getLineNumber(), this));
	}

	public String getPieceId(Position position)
	{
		return grid.getPieceId(position);
	}
}
