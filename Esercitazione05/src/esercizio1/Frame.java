package esercizio1;

import java.awt.*;
import java.net.PasswordAuthentication;

import javax.swing.*;

public class Frame extends JFrame {
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	//Definisco Java Field
	private JPasswordField pass = new JPasswordField();
	private JLabel label = new JLabel();
	private JTextArea text = new JTextArea();
	private JButton[] buttons = new JButton[12];
	//Definisco i JPanel
	private JPanel sxUP = new JPanel(new BorderLayout());
	private JPanel sxDown = new JPanel(new GridLayout(4, 3));
	private JPanel dx = new JPanel(new BorderLayout());

	public Frame(String s) {
		super(s);

		this.setSize(dim.width / 3, dim.height / 3);
		this.setLocationRelativeTo(null);// uguale a this.setLocation(dim.width ...);
		
		setJField();
		Container contentPane = setContentPane();

		addComponents();
		
		setListeners();

		// Aggiungo i JPanel al ContentPane
		contentPane.add(sxUP);
		contentPane.add(dx);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setListeners() {
		//Setto i listener
		buttons[0].setActionCommand("show");
		buttons[1].setActionCommand("digit");
		buttons[2].setActionCommand("cancel");
		for (int i = 3; i < buttons.length; i++) {
			buttons[i].setActionCommand("digit");
		}
	}

	private void addComponents() {
		// Aggiungo i componenti ai JPanel
		dx.add(BorderLayout.NORTH, label);
		dx.add(BorderLayout.CENTER, text);
		sxUP.add(BorderLayout.NORTH, pass);
		sxUP.add(BorderLayout.CENTER, sxDown);
		
		String[] stringData = {"Mostra", "0", "C", "9", "8", "7", "6", "5","4","3","2","1"}; 
		for(int i = 0 ; i < 12; i++) {
			buttons[i] = new JButton(stringData[stringData.length-1-i]);
			sxDown.add(buttons[i]);
		}
	}

	private Container setContentPane() {
		//Organizzo il contentPane
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		return contentPane;
	}

	private void setJField() {
		//Setto i JField
		text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text.setEditable(false);
		pass.setEditable(false);
		label.setText("Codice digitato: ");
	}
}
