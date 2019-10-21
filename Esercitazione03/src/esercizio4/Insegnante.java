package esercizio4;

public class Insegnante {
	private String nome;
	private String cognome;
	private int annoVincita;
	private Scuola scuola;
	
	public Insegnante(String nome, String cognome, int annoVincita, Scuola scuola) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setAnnoVincita(annoVincita);
		this.setScuola(scuola);
	}

	//Servizi
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnnoVincita() {
		return annoVincita;
	}

	public void setAnnoVincita(int annoVincita) {
		this.annoVincita = annoVincita;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
