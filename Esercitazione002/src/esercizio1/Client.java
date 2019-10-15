package esercizio1;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire stringa:");
		String s1 = sc.nextLine();
		System.out.print("Inserire stringa:");
		String s2 = sc.nextLine();
		sc.close();
		
		System.out.println(StringUtility.checkString(s2, s1));
	}

}
