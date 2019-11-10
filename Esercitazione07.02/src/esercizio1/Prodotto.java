package esercizio1;

public class Prodotto {
	private String codice;
	private String descrizione;
	private Fornitore fornitore;
	private double prezzoVendita;
	private int numero;
	

	public Prodotto(String codice, String descrizione, Fornitore fornitore, double prezzoVendita, int numero) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.fornitore = fornitore;
		this.prezzoVendita = prezzoVendita;
		this.numero = numero;
	}


	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Fornitore getFornitore() {
		return fornitore;
	}


	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}


	public double getPrezzoVendita() {
		return prezzoVendita;
	}


	public void setPrezzoVendita(double prezzoVendita) {
		this.prezzoVendita = prezzoVendita;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}

}
