package fr.iutvalence.ardechois.klotski.view.GUI;

import javax.swing.JFrame;


public class JFrameGame implements Runnable
{
	private int level;
	
	public JFrameGame(int level)
	{
		this.level = level;
	}

	@Override
	public void run()
	{
		// JFrame de jeu selon le levels
		JFrame frame = new JFrame("Test");
		frame.setVisible(true);
	}
	
}
