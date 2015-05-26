package fr.iutvalence.ardechois.klotski.view.GUI;

import javax.swing.JFrame;
import fr.iutvalence.ardechois.klotski.model.GridTypes;


public class JFrameGame implements Runnable
{
	private GridTypes gridType;
	
	public JFrameGame(GridTypes gridType)
	{
		this.gridType = gridType;
	}

	@Override
	public void run()
	{
		// JFrame de jeu selon le levels
		JFrame frame = new JFrame("Game");
		frame.setVisible(true);
	}
	
}
