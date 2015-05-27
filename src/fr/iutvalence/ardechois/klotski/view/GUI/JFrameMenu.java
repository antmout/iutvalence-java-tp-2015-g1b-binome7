package fr.iutvalence.ardechois.klotski.view.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.iutvalence.ardechois.klotski.model.GridTypes;

public class JFrameMenu extends JFrame
{
	public static final String TITLE = "Main Menu";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrameMenu(GUIKlotski controller)
	{
		super(JFrameMenu.TITLE);

		setSize(JFrameMenu.WIDTH, JFrameMenu.HEIGHT);
		
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, WIDTH, 70));
		
		JLabel title = new JLabel("Klotski");
		title.setFont(new Font("Arial", Font.PLAIN, 60));
		panel.add(title);
		
		JButton basic = new JButton(new ActionLaunch(this, GridTypes.BASIC, controller));
		basic.setPreferredSize(new Dimension(200, 50));
		basic.setFont(new Font("Arial", Font.PLAIN, 25));
		basic.setText("Basic");
		panel.add(basic);
		
		JButton reversed = new JButton(new ActionLaunch(this, GridTypes.REVERSED, controller));
		reversed.setPreferredSize(new Dimension(200, 50));
		reversed.setFont(new Font("Arial", Font.PLAIN, 25));
		reversed.setText("Reversed");
		panel.add(reversed);
		
		JButton doubl = new JButton(new ActionLaunch(this, GridTypes.DOUBLE, controller));
		doubl.setPreferredSize(new Dimension(200, 50));
		doubl.setFont(new Font("Arial", Font.PLAIN, 25));
		doubl.setText("Double");
		panel.add(doubl);
		
		this.setContentPane(panel);
		
		setVisible(true);
	}

}
