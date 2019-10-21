package esercizio2;

public class Conto {
	private String nome;
	private String cognome;
	private int saldo;
	private String codice;

	public Conto(String nome, String cognome, int saldo, String codice) {
		this.nome = nome;
		this.cognome = cognome;
		this.saldo = saldo;
		this.codice = codice;
	}
	
	//Services
	public void deposito(int cifra) {
		this.saldo += cifra;
	}
	public void prelievo(int cifra) {
		this.saldo -= cifra;
	}
	

	// Getters and setters
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
