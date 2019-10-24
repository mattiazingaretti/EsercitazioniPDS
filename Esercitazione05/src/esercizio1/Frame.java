package esercizio1;

import java.awt.*;
import java.net.PasswordAuthentication;

import javax.swing.*;

public class Frame extends JFrame {
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	// Definisco Java Field
	private JPasswordField pass = new JPasswordField();
	private JLabel label = new JLabel();
	private JTextArea text = new JTextArea();
	private JButton[] buttons = new JButton[12];
	// Definisco i JPanel
	private JPanel sxUP = new JPanel(new BorderLayout());
	private JPanel sxDown = new JPanel(new GridLayout(4, 3));
	private JPanel dx = new JPanel(new BorderLayout());
	public final static String TITLE = "Pannello Digitale";

	public Frame() {
		super(Frame.TITLE);

		this.setSize(dim.width / 3, dim.height / 3);
		this.setLocationRelativeTo(null);// uguale a this.setLocation(dim.width ...);

		setJField();
		Container contentPane = setContentPane();

		// Aggiungo i componenti ai JPanel
		dx.add(BorderLayout.NORTH, label);
		dx.add(BorderLayout.CENTER, text);
		sxUP.add(BorderLayout.NORTH, pass);
		sxUP.add(BorderLayout.CENTER, sxDown);
		String[] stringData = { "Mostra", "0", "C", "9", "8", "7", "6", "5", "4", "3", "2", "1" };
		for (int i = 0; i < 12; i++) {
			buttons[i] = new JButton(stringData[stringData.length - 1 - i]);
			sxDown.add(buttons[i]);
		}

		// Setto i listener
		Logic l = new Logic(pass, label ,text );
		buttons[11].setActionCommand("show");
		buttons[11].addActionListener(l);
		buttons[10].setActionCommand("digit");
		buttons[10].addActionListener(l);
		buttons[9].setActionCommand("cancel");
		buttons[9].addActionListener(l);
		for (int i = 8; i >= 0; i--) {
			buttons[i].setActionCommand("digit");
			buttons[i].addActionListener(l);
		}
		
		
		// Aggiungo i JPanel al ContentPane
		contentPane.add(sxUP);
		contentPane.add(dx);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	private Container setContentPane() {
		// Organizzo il contentPane
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		return contentPane;
	}

	private void setJField() {
		// Setto i JField
		text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text.setEditable(false);
		label.setText("Codice digitato: ");
	}

	// Getters and setters
	public JPasswordField getPass() {
		return pass;
	}

	public void setPass(JPasswordField pass) {
		this.pass = pass;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	
}
