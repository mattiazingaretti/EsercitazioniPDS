package esercizio1;
/**
 * Abstract class that represents a figure
 * @author zingaretti mattia
 *
 */
public abstract class Figure {
	//Services
	public abstract double area() ;
	public abstract double perimetro();
	public abstract String toString();
	
	public static double sommaAree(Figure[] f) {
		double sum = 0;
		for (int i = 0; i < f.length; i++) {
			sum += f[i].area();
		}
		return sum;
	}
}
