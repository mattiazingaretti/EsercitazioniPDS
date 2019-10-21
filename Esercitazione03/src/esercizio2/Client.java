package esercizio2;

public class Client {

	public static void main(String[] args) {
		double[][] mat = esercizio1.UtilMatrice.generaMatrice(3, 3);
		esercizio1.UtilMatrice.stampaMatrice(mat);
		System.out.println("\n");
		esercizio1.UtilMatrice.stampaMatrice(esercizio2.UtilMatrice.differenzaVicini(mat));
	}

}
