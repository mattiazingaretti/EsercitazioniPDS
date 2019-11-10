package esercizio1;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class GUIPersone extends JFrame implements Lockable{
	
	private boolean statusInserimento;
	
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
	private JLabel partitaIVA = new JLabel("Partita IVA Fornitore");
	private JTextField nomeTextC = new JTextField(10);
	private JTextField cognomeTextC = new JTextField(10);
	private JTextField indirizzoTextC = new JTextField(10);
	private JTextField codiceFiscaleTextC = new JTextField(10);
	
	private JTextField nomeTextF = new JTextField(10);
	private JTextField cognomeTextF = new JTextField(10);
	private JTextField indirizzoTextF = new JTextField(10);
	private JTextField partitaIVATextF = new JTextField(10);	
	
	private JButton aggCliente = new JButton("Aggiungi Cliente");
	private JButton aggFornitore = new JButton("Aggiungi Fornitore");
	private JButton aggTerminata = new JButton("Aggiunta Terminata");
	
	
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
		
		right.add(nomeF);
		right.add(nomeTextF);
		right.add(cognmeF);
		right.add(cognomeTextF);
		right.add(indirizzoF);
		right.add(indirizzoTextF);
		right.add(partitaIVA);
		right.add(partitaIVATextF);
	
		bottom.add(aggCliente);
		bottom.add(aggTerminata);
		bottom.add(aggFornitore);
		

		
		Logic l = new Logic(dbClienti, dbFornitori, this);
		
		aggCliente.addActionListener(l);
		aggCliente.setActionCommand("addC");
		
		aggFornitore.addActionListener(l);
		aggFornitore.setActionCommand("addF");
		
		aggTerminata.addActionListener(l);
		aggTerminata.setActionCommand("done");
		
		this.setStatusInserimento(true);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		this.setVisible(true);
	}

	
	public boolean isStatusInserimento() {
		return statusInserimento;
	}


	public void setStatusInserimento(boolean statusInserimento) {
		this.statusInserimento = statusInserimento;
	}


	@Override
	public boolean isLocked() {
		return this.statusInserimento;
	}


	@Override
	public void unlock() {
		this.setStatusInserimento(false);
	}


	public JPanel getLeft() {
		return left;
	}


	public void setLeft(JPanel left) {
		this.left = left;
	}


	public JPanel getRight() {
		return right;
	}


	public void setRight(JPanel right) {
		this.right = right;
	}


	public JPanel getBottom() {
		return bottom;
	}


	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}


	public JLabel getNomeC() {
		return nomeC;
	}


	public void setNomeC(JLabel nomeC) {
		this.nomeC = nomeC;
	}


	public JLabel getCognmeC() {
		return cognmeC;
	}


	public void setCognmeC(JLabel cognmeC) {
		this.cognmeC = cognmeC;
	}


	public JLabel getIndirizzoC() {
		return indirizzoC;
	}


	public void setIndirizzoC(JLabel indirizzoC) {
		this.indirizzoC = indirizzoC;
	}


	public JLabel getCodiceFiscaleC() {
		return codiceFiscaleC;
	}


	public void setCodiceFiscaleC(JLabel codiceFiscaleC) {
		this.codiceFiscaleC = codiceFiscaleC;
	}


	public JLabel getNomeF() {
		return nomeF;
	}


	public void setNomeF(JLabel nomeF) {
		this.nomeF = nomeF;
	}


	public JLabel getCognmeF() {
		return cognmeF;
	}


	public void setCognmeF(JLabel cognmeF) {
		this.cognmeF = cognmeF;
	}


	public JLabel getIndirizzoF() {
		return indirizzoF;
	}


	public void setIndirizzoF(JLabel indirizzoF) {
		this.indirizzoF = indirizzoF;
	}


	public JLabel getPartitaIVA() {
		return partitaIVA;
	}


	public void setPartitaIVA(JLabel partitaIVA) {
		this.partitaIVA = partitaIVA;
	}


	public JTextField getNomeTextC() {
		return nomeTextC;
	}


	public void setNomeTextC(String t) {
		this.nomeTextC.setText(t);
	}


	public JTextField getCognomeTextC() {
		return cognomeTextC;
	}


	public void setCognomeTextC(String t) {
		this.cognomeTextC.setText(t);
	}


	public JTextField getIndirizzoTextC() {
		return indirizzoTextC;
	}


	public void setIndirizzoTextC(String indirizzoTextC) {
		this.indirizzoTextC.setText(indirizzoTextC);
	}


	public JTextField getCodiceFiscaleTextC() {
		return codiceFiscaleTextC;
	}


	public void setCodiceFiscaleTextC(String s) {
		this.codiceFiscaleTextC.setText(s);
	}


	public JTextField getNomeTextF() {
		return nomeTextF;
	}


	public void setNomeTextF(String s) {
		this.nomeTextF.setText(s);
	}


	public JTextField getCognomeTextF() {
		return cognomeTextF;
	}


	public void setCognomeTextF(String s) {
		this.cognomeTextF.setText(s);
	}


	public JTextField getIndirizzoTextF() {
		return indirizzoTextF;
	}


	public void setIndirizzoTextF(String t) {
		this.indirizzoTextF.setText(t);
	}


	public JTextField getPartitaIVATextF() {
		return partitaIVATextF;
	}


	public void setPartitaIVATextF(String t) {
		this.partitaIVATextF.setText(t);
	}


	public JButton getAggCliente() {
		return aggCliente;
	}


	public void setAggCliente(JButton aggCliente) {
		this.aggCliente = aggCliente;
	}


	public JButton getAggFornitore() {
		return aggFornitore;
	}


	public void setAggFornitore(JButton aggFornitore) {
		this.aggFornitore = aggFornitore;
	}


	public JButton getAggTerminata() {
		return aggTerminata;
	}


	public void setAggTerminata(JButton aggTerminata) {
		this.aggTerminata = aggTerminata;
	}


	

}
