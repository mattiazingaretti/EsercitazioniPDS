package esercizio6;

import java.util.Scanner;

/**
 * Iterativly calculate a triangle area.
 * 
 * @author zingaretti mattia
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		calculate();
		sc.close();
	}

	private static double getBase() {
		// Getting data
		System.out.print("Insert Base: ");
		double base = Double.parseDouble(sc.nextLine());
		return base;
	}

	private static double getHeight() {
		// Getting data
		System.out.print("Insert Height : ");
		double height = Double.parseDouble(sc.nextLine());
		return height;
	}


	private static void calculate() {
		double base;
		double height;
		do {
			base = getBase();
			height = getHeight();
			double area = (base * height) / 2;
			if(area>=0) {System.out.println("Area : " + area+"\n");}
		} while (base >= 0 && height >= 0);
	}

}
