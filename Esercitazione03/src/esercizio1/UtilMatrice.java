package esercizio1;
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

	public static void stampaArray(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	public static double[] diagonale(double[][] mat) {
		int min = Math.min(mat.length, mat[0].length);
		double[] arr = new double[min];
		for (int i = 0; i < min; i++) {
			for (int j = 0; j < min; j++) {
				if (j == i ) {
					arr[j] = mat[i][j];
				}
			}
		}
		return arr;
	}

	public static double sommaArray(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}


}

