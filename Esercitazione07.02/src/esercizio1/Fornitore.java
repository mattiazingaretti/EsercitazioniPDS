package esercizio1;

public class Fornitore {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String partitaIVA;
	

	public Fornitore(String nome, String cognome, String indirizzo, String partitaIVA) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.partitaIVA = partitaIVA;
	}
	
	public String toString() {
		return "Fornitore: "+this.nome+ " "+ this.cognome+ " residente a : "+this.indirizzo+ " Partita IVA: "+this.partitaIVA;
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
	public String getPartitaIVA() {
		return partitaIVA;
	}
	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	

}
