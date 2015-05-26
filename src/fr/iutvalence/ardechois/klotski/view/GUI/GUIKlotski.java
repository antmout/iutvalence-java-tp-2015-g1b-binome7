package fr.iutvalence.ardechois.klotski.view.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import fr.iutvalence.ardechois.klotski.model.BasicKlotskiGrid;
import fr.iutvalence.ardechois.klotski.model.Grid;

public class GUIKlotski
{
	private Grid grid;
	
	public GUIKlotski()
	{
		JFrame menu = new JFrameMenu(this);
	}
	
	public void initParty(int level) {
		switch (level) {
			case 1:
			case 2:
			case 3:
			default:
				grid = new BasicKlotskiGrid();
				break;
		}
		SwingUtilities.invokeLater(new JFrameGame(level));
	}
}
