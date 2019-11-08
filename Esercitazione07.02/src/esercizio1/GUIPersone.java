package esercizio1;

import java.awt.*;
import java.util.List;

import javax.swing.*;

public class GUIPersone extends JFrame{
	
	private JPanel left = new JPanel(new FlowLayout());
	private JPanel right = new JPanel(new FlowLayout());
	private JPanel bottom = new JPanel(new FlowLayout());
	
	private JLabel nomeC = new JLabel("Nome Cliente");
	private JLabel cognmeC = new JLabel("Cognome Cliente");
	private JLabel indirizzoC = new JLabel("Indirizzo Cliente");
	private JLabel codiceFiscaleC = new JLabel("Codice Fiscale Cliente");

	private JLabel nomeF = new JLabel("Nome Fornitore");
	private JLabel cognmeF = new JLabel("Cognome Fornitore");
	private JLabel indirizzoF = new JLabel("Indirizzo Fornitore");
	private JLabel codiceFiscaleF = new JLabel("Codice Fiscale Fornitore");

	private JTextField nomeTextC = new JTextField(1);
	private JTextField cognomeTextC = new JTextField(1);
	private JTextField indirizzoTextC = new JTextField(1);
	private JTextField codiceFiscaleTextC = new JTextField(1);

	private JTextField nomeTextF = new JTextField(1);
	private JTextField cognomeTextF = new JTextField(1);
	private JTextField indirizzoTextF = new JTextField(1);
	private JTextField codiceFiscaleTextF = new JTextField(1);	

	private JButton aggCliente = new JButton("Aggiungi Cliente");
	private JButton aggFornitore = new JButton("Aggiungi Fornitore");
	private JButton aggTerminata = new JButton("Aggiunta Terminata");
	
	public GUIPersone() {		
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		this.setVisible(true);
		
	}
	
	public GUIPersone(List<Cliente> dbClienti, List<Fornitore> dbFornitori) {

	}

	public boolean isLocked() {
	
		return false;
	}

	

}
