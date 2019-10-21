package esercizio2;

public class ContoCredito extends Conto{
	private static final int LIMIT = 4;
	private int commissione;
	private static int numOP;
	
	public ContoCredito(String nome, String cognome, int saldo, String codice) {
		super(nome, cognome, saldo, codice);
		this.numOP = 0;
		
	}
	@Override
	public void deposito(int cifra) {
		if(numOP < LIMIT) {
			this.setSaldo(this.getSaldo() + cifra);
			numOP++;
		}else {
			this.setSaldo(this.getSaldo() + cifra - this.commissione);
			numOP++;
		}
	}
	
	public void prelievo(int cifra) {
		this.deposito(cifra*(-1)); //lil bitch
	}

}
