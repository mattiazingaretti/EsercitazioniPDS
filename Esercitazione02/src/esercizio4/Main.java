package esercizio4;

import java.util.Scanner;

/**
 * String ratio calculator
 * @author zingaretti mattia
 */
public class Main {

	public static void main(String[] args) {
		//Getting 2 string
		Scanner sc = new Scanner(System.in);
		System.out.print("Put numerator: ");
		String s1 = sc.nextLine();
		System.out.print("Put denominator: ");
		String s2 = sc.nextLine();
		sc.close();
		System.out.print((int)s1.length()/s2.length());
	}

}
