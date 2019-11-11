package esercizio1;

public class Cliente {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String codiceFiscale;
	
	
	public Cliente(String nome, String cognome, String codiceFiscale, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}
	
	@Override
	public String toString() {
		return "Cliente "+ this.cognome+ " " + this.cognome+" residente a : "+ this.indirizzo;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


}
