package esercizio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Logic implements ActionListener{
	private String pin;
	
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
			break;
		default:
			break;
		}
		
	}

	private void storeDigit(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		this.pin += btn.getText();
	}

	private void showPassword(ActionEvent e) {
		
		
	}
	
}
