package esercizio2;

public class ContoCredito extends Conto{
	private static final int LIMIT = 4;
	private int commissione = 40;
	private int numOP;
	
	public ContoCredito(String nome, String cognome, int saldo, String codice) {
		super(nome, cognome, saldo, codice);
		this.numOP = 0;
	}
	@Override
	public void deposito(int cifra) {
		if(numOP < LIMIT) {
			this.setSaldo(this.getSaldo() + cifra);
			this.numOP++;
		}else {
			this.setSaldo(this.getSaldo() + cifra - this.commissione);
			this.numOP++;
		}
	}
	@Override
	public void prelievo(int cifra) {
		this.deposito(cifra*(-1)); //lil bitch
	}
	
	//Services
	void reset() {
		this.numOP = 0;
	}
	
	//Getters and setters
	public int getCommissione() {
		return commissione;
	}
	public void setCommissione(int commissione) {
		this.commissione = commissione;
	}
}
