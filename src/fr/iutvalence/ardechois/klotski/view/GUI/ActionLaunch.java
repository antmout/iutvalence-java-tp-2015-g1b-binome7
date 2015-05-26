package fr.iutvalence.ardechois.klotski.view.GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import fr.iutvalence.ardechois.klotski.view.console.GridTypes;

public class ActionLaunch extends AbstractAction
{

	private int level;
	private GUIKlotski controller;
	private JFrame frame;

	public ActionLaunch(JFrame frame, int d, GUIKlotski controller)
	{
		this.frame = frame;
		this.level = d;
		this.controller = controller;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Basic");
		controller.initParty(level);
		frame.dispose();
	}

}
