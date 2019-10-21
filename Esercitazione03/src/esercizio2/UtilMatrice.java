package esercizio2;

public class UtilMatrice {

	public static double[][] differenzaVicini(double[][] matrix) {

		double[][] res = new double[matrix.length][matrix[0].length];
		//TODO Try to implement it in O(n^2)... with all the cases.
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				double elem = matrix[i][j];
				int sx, dx, up, dw;

				if (j != 0)
					sx = j - 1;
				else
					sx = j;

				if (j != matrix[0].length - 1)
					dx = j + 1;
				else
					dx = j;

				if (i != 0)
					up = i - 1;
				else
					up = i;

				if (i != matrix.length - 1)
					dw = i + 1;
				else
					dw = i;

				double sum = 0.0;
				for (int h = up; h <= dw; h++) {
					for (int k = sx; k <= dx; k++) {
						if (!(h == i && k == j))
							sum = sum + matrix[h][k];
					}
				}
				res[i][j] = elem - sum;
			}
		}

		return res;
	}
}