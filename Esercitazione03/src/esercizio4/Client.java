package esercizio4;

public class Client {
	
	public static void main(String[] args) {
		Scuola sc = new Scuola("scuola", "Via de torbella", "Roma");
		Insegnante ins1 = new Insegnante("Gioele", "Zacchia", 19998, sc);
		Insegnante ins2 = new Insegnante("Gioele", "Zacchia", 19998, sc);
		Insegnante ins3 = new Insegnante("Gioele", "Zacchia", 19998, sc);
		
		Classe c = new Classe(sc, ins1, ins2, ins3, 3, "VC");
		c.stampa();
	}

}
