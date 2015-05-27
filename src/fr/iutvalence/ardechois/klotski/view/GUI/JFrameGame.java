package fr.iutvalence.ardechois.klotski.view.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.iutvalence.ardechois.klotski.model.Position;

public class JFrameGame extends JFrame
{
	
	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	/**
	 * Window height without borders.
	 */
	public static final int INSIDE_HEIGHT = 562;
	public static final int TITLE_SIZE = 20;
	
	private GUIKlotski controller;
	
	public JFrameGame(String frameTitle, int gridWidth, int gridHeight, GUIKlotski controller)
	{
		super(frameTitle);
		
		this.controller = controller;
		
		setSize(JFrameGame.WIDTH, JFrameGame.HEIGHT);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		// grid creation
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, WIDTH, 0));
		
		JLabel title = new JLabel("Klotski");
		title.setFont(new Font("Arial", Font.PLAIN, TITLE_SIZE));
		mainPanel.add(title);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(gridHeight, gridWidth));
		
		JLabel test;
		
		for(int y=0; y<gridHeight; y++)
		{
			for(int x=0; x<gridWidth; x++)
			{
				test = new JLabel(controller.getPieceId(new Position(x, y)));
				test.setPreferredSize(new Dimension((INSIDE_HEIGHT-TITLE_SIZE*2)/gridHeight, (INSIDE_HEIGHT-TITLE_SIZE*2)/gridHeight));
				test.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
				test.setHorizontalAlignment(0);
				gridPanel.add(test);
			}
		}
		
		mainPanel.add(gridPanel);

		this.setContentPane(mainPanel);
		
		this.setVisible(true);
	}
}
