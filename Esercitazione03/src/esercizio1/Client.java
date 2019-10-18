package esercizio1;

public class Client {

	public static void main(String[] args) {
		double[][] mat = UtilMatrice.generaMatrice(5, 6);	
		UtilMatrice.stampaMatrice(mat);
		double[] diag = UtilMatrice.diagonale(mat);
		double s = UtilMatrice.sommaArray(diag);
		System.out.println("\n");
		UtilMatrice.stampaArray(diag);
		System.out.println("\n");
		System.out.println(s);
	}

}
