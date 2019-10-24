package org.zingaretti.mattia.fase2.gui;

import java.awt.*;
import javax.swing.*;

/**
 * Class for editing the graphical interface of the application. Kept for future
 * editings.
 * 
 * @author mattiazingaretti
 *
 */
public class InputFrame extends JFrame{
	//Get device screen size
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public InputFrame(String title) {
		super(title);
		
		this.setSize(dim.width/3, dim.height/3);

		//Centering the frame
		this.setLocationRelativeTo(null);//Same instruction as below
		//this.setLocation(dim.width/2 -this.getWidth()/2, dim.height/2 - this.getHeight()/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		Container contentPane = this.getContentPane();
		contentPane.add(new JPanel());
		
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Insert Data"));
		
		this.setVisible(true);
	}
	
	
	
}
