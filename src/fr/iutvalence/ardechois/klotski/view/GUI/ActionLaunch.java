package fr.iutvalence.ardechois.klotski.view.GUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import fr.iutvalence.ardechois.klotski.model.GridTypes;

public class ActionLaunch extends AbstractAction
{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private GridTypes gridType;
	private GUIKlotski controller;
	private JFrame frame;

	public ActionLaunch(JFrame frame, GridTypes gridType, GUIKlotski controller)
	{
		this.frame = frame;
		this.gridType = gridType;
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		controller.initGame(gridType);
		frame.dispose();
	}
}
