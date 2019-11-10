package esercizio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Logic implements ActionListener{

	private List<Fornitore> dbFornitore;
	private List<Cliente> dbCliente;
	private GUIPersone persona ;

	public Logic(List<Cliente> datiCliente, List<Fornitore> datiFornitore,GUIPersone p) {
		super();
		this.dbFornitore = datiFornitore;
		this.dbCliente = datiCliente;
		this.persona = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "addC":
			aggiungiCliente();
			break;
		case "addF":
			aggiungiFornitore();
			break;
		case "done":
			aggiuntaTerminata();
			break;
		}
	}

	private void aggiungiFornitore() {
		String nome = this.persona.getNomeTextF().getText();
		String cognome = this.persona.getCognomeTextF().getText();
		String indirizzo = this.persona.getIndirizzoTextF().getText();
		String partitaIva = this.persona.getPartitaIVATextF().getText();
				
		boolean check = false;
		if(partitaIva.matches("\\d{11}")) {
			check = true;
		}
		if(nome != null && cognome != null && indirizzo != null && partitaIva != null && check) {
			Fornitore fornitore = new Fornitore(nome, cognome, indirizzo, partitaIva);
			dbFornitore.add(fornitore);
			
		}else {
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(null, "Ao metti tutti i valori per bene");
		}
		
		this.persona.setNomeTextF("");
		this.persona.setCognomeTextF("");
		this.persona.setIndirizzoTextF("");
		this.persona.setPartitaIVATextF("");
		
	}

	private void aggiuntaTerminata() {
		
		if(this.dbCliente.isEmpty() == false && this.dbFornitore.isEmpty()== false) {
			this.persona.setStatusInserimento(false);
		}
		else {
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(null, "Ao metti almeno un fornitore e un cliente!");
		}
		
		
		this.persona.setNomeTextF("");
		this.persona.setCognomeTextF("");
		this.persona.setIndirizzoTextF("");
		this.persona.setPartitaIVATextF("");

		this.persona.setNomeTextC("");
		this.persona.setCognomeTextC("");
		this.persona.setIndirizzoTextC("");
		this.persona.setCodiceFiscaleTextC("");

	}

	private void aggiungiCliente() {
		String nome = this.persona.getNomeTextC().getText();
		String cognome = this.persona.getCognomeTextC().getText();
		String indirizzo = this.persona.getIndirizzoTextC().getText(); 
		String codiceFiscale = this.persona.getCodiceFiscaleTextC().getText();
		boolean check = false;
		if(codiceFiscale.length() == 16 ) {
			check = codiceFiscale.matches("\\w{6}\\d{2}\\w{1}\\d{2}\\w{1}\\d{3}\\w{1}");
		}
		
		if (nome != null && cognome != null && indirizzo != null && codiceFiscale != null && check) {
			Cliente cliente = new Cliente(nome, cognome, indirizzo, codiceFiscale);
			this.dbCliente.add(cliente);
		}else {
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(null, "Ao metti tutti i valori per bene");
		}
		
		this.persona.setNomeTextC("");
		this.persona.setCognomeTextC("");
		this.persona.setIndirizzoTextC("");
		this.persona.setCodiceFiscaleTextC("");
	}

	public List<Fornitore> getDatiFornitore() {
		return dbFornitore;
	}

	public void setDatiFornitore(List<Fornitore> datiFornitore) {
		this.dbFornitore = datiFornitore;
	}

	public List<Cliente> getDatiCliente() {
		return dbCliente;
	}

	public void setDatiCliente(List<Cliente> datiCliente) {
		this.dbCliente = datiCliente;
	}

}
