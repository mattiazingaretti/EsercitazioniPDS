package esercizio4;

public class Scuola {

	private  String nome;
	private  String indirizzo;
	private  String provveditorato;
	
	//Constructor
	public Scuola(String nome, String indirizzo, String provveditorato) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.provveditorato = provveditorato;
	}
	
	//Servizio
	
	//Getters Setters
	public String getNome() {
		return nome;
	}

	public String getProvveditorato() {
		return provveditorato;
	}

	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setProvveditorato(String provveditorato) {
		this.provveditorato = provveditorato;
	}


}
