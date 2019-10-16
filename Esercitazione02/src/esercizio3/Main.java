package esercizio3;

import java.util.Scanner;

/**
 * Is a leap year ? Let's figure it out. So much fun...
 * @author zingaretti mattia
 */
public class Main {

	public static void main(String[] args) {
		//Getting data
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert a year: ");
		int year = Integer.parseInt(sc.nextLine());
		sc.close();
		
		System.out.println( year%4==0 || year%400 == 0);
	}

}
