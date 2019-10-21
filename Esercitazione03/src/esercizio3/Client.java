package esercizio3;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		//get data
		System.out.print("Inserisci dati : \n");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] ar  = line.split(",");
		int r = Integer.parseInt(ar[0]);
		int c = Integer.parseInt(ar[1]);
		double[][] mat = new double[r][c];
		for (int i = 0; i < r; i++) {
				line = sc.nextLine();
				ar = line.split(",");
				for (int j = 0; j < ar.length; j++) {
					mat[i][j] = Double.parseDouble(ar[j]);
				}
		}
		sc.close();
		
		esercizio1.UtilMatrice.stampaMatrice(esercizio2.UtilMatrice.differenzaVicini(mat));
		

	}

}