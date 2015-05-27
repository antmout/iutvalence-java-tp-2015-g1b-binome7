package fr.iutvalence.ardechois.klotski.view.GUI;

import javax.swing.JFrame;
import fr.iutvalence.ardechois.klotski.model.GridTypes;


public class RunnableGame implements Runnable
{
	private GridTypes gridType;
	private int gridWidth;
	private int gridHeight;
	private GUIKlotski controller;
	
	public RunnableGame(GridTypes gridType, int gridWidth, int gridHeight, GUIKlotski controller)
	{
		this.gridType = gridType;
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.controller = controller;
	}

	@Override
	public void run()
	{
		// JFrame de jeu selon le level.
		JFrame frame = new JFrameGame(gridType.toString(), gridWidth, gridHeight, controller);
		frame.setVisible(true);
	}
}
