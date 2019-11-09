package esercizio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Logic implements ActionListener{
	
	private JTextField[] datiFornitore;
	private JTextField[] datiCliente;
	
	
	public Logic(JTextField[] datiCliente, JTextField[] datiFornitore) {
		super();
		this.datiFornitore = datiFornitore;
		this.datiCliente = datiCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
