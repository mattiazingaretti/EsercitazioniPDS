package esercizio1;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class GUIPersone extends JFrame{
	
	private JPanel left = new JPanel(new GridLayout(4,2));
	private JPanel right = new JPanel(new GridLayout(4,2));
	private JPanel bottom = new JPanel(new FlowLayout());
	
	private JLabel nomeC = new JLabel("Nome Cliente");
	private JLabel cognmeC = new JLabel("Cognome Cliente");
	private JLabel indirizzoC = new JLabel("Indirizzo Cliente");
	private JLabel codiceFiscaleC = new JLabel("Codice Fiscale Cliente");

	private JLabel nomeF = new JLabel("Nome Fornitore");
	private JLabel cognmeF = new JLabel("Cognome Fornitore");
	private JLabel indirizzoF = new JLabel("Indirizzo Fornitore");
	private JLabel codiceFiscaleF = new JLabel("Codice Fiscale Fornitore");

	private JTextField nomeTextC = new JTextField(10);
	private JTextField cognomeTextC = new JTextField(10);
	private JTextField indirizzoTextC = new JTextField(10);
	private JTextField codiceFiscaleTextC = new JTextField(10);
	private JTextField[] datiCliente = {nomeTextC, cognomeTextC, indirizzoTextC, codiceFiscaleTextC};
	
	private JTextField nomeTextF = new JTextField(10);
	private JTextField cognomeTextF = new JTextField(10);
	private JTextField indirizzoTextF = new JTextField(10);
	private JTextField codiceFiscaleTextF = new JTextField(10);	
	private JTextField[] datiFornitore = {nomeTextF, cognomeTextF, indirizzoTextF, codiceFiscaleTextF};
	
	private JButton aggCliente = new JButton("Aggiungi Cliente");
	private JButton aggFornitore = new JButton("Aggiungi Fornitore");
	private JButton aggTerminata = new JButton("Aggiunta Terminata");
	
	public GUIPersone() {		
		super();
	}
	
	public GUIPersone(List<Cliente> dbClienti, List<Fornitore> dbFornitori) {
		super();
		
		Container cntPane = this.getContentPane();
		cntPane.setLayout(new BorderLayout());
		
		cntPane.add(left, BorderLayout.WEST);
		cntPane.add(right , BorderLayout.EAST);
		cntPane.add(bottom, BorderLayout.SOUTH);
		
		left.add(nomeC);
		left.add(nomeTextC);
		left.add(cognmeC);
		left.add(cognomeTextC);
		left.add(indirizzoC);
		left.add(indirizzoTextC);
		left.add(codiceFiscaleC);
		left.add(codiceFiscaleTextC);
		//left.add(aggCliente);
		
		right.add(nomeF);
		right.add(nomeTextF);
		right.add(cognmeF);
		right.add(cognomeTextF);
		right.add(indirizzoF);
		right.add(indirizzoTextF);
		right.add(codiceFiscaleF);
		right.add(codiceFiscaleTextF);
		//right.add(aggFornitore);
		bottom.add(aggCliente);
		bottom.add(aggTerminata);
		bottom.add(aggFornitore);
		
		Logic l = new Logic(datiCliente, datiFornitore);
		
		aggCliente.addActionListener(l);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		this.setVisible(true);
	}

	
	public boolean isLocked() {
	
		return false;
	}

	

}
