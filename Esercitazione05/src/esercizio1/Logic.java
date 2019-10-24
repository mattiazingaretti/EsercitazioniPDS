package esercizio1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Logic implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String pin = "";
	private JTextArea area;
	private JLabel label;
	private JPasswordField pass ;
	
	public Logic(JPasswordField pass, JLabel label, JTextArea text) {
		super();
		this.area = text;
		this.label = label;
		this.pass = pass;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		switch (com) {
		case "show":
			showPassword(e);
			break;
		case "digit":
			storeDigit(e);
			break;
		case "cancel":
			cancelDigit(e);
			break;
		default:
			break;
		}
		
	}

	private void cancelDigit(ActionEvent e) {
		this.pin = "";
		pass.setText("");
		area.setText("");
		label.setText(Frame.TITLE);
	}



	private void storeDigit(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		pin += btn.getText();
		pass.setText(pass.getText() + btn.getText());
	}

	private void showPassword(ActionEvent e) {
		this.area.setText(this.pin);
		this.label.setText("PIN");
	}
	

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
