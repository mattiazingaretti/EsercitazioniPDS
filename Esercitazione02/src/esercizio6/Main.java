package esercizio6;

import java.util.Scanner;

/**
 * Iterativly calculate a triangle area.
 * @author zingaretti mattia
 *
 */
public class Main {

	public static void main(String[] args) {
		//Getting data
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert Base: ");
		double base = Double.parseDouble(sc.nextLine());
		System.out.print("Insert Height : ");
		double height = Double.parseDouble(sc.nextLine());
		sc.close();
		
		calculate( base, height);
	}

	private static void calculate( double base, double height) {
		Scanner scanner = new Scanner(System.in);
		while(base >= 0 && height >=0 ) {
			double area = (base*height)/2;
			System.out.print("Area : "+ area);
		}
		scanner.close();
	}

}
