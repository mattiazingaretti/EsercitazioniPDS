package esercizio2;

public class ContoDebito extends Conto {
	public ContoDebito(String nome, String cognome, int saldo, String codice) {
		super(nome, cognome, saldo, codice);
	}

	void riconosciInteresse(double interesse) {
		this.setSaldo((int)(this.getSaldo()+this.getSaldo()*interesse));
	}
	

}
