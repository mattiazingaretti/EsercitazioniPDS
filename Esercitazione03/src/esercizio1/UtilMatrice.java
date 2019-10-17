package esercizio1;

import java.util.Iterator;

/**
 * Some utilities for matrices
 * 
 * @author zingaretti mattia
 *
 */
public class UtilMatrice {

	public static double[][] generaMatrice(int n, int m) {
		double[][] mat = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = 100 * Math.random();
			}
		}
		return mat;
	}

	public static void stampaMatrice(double[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
}


