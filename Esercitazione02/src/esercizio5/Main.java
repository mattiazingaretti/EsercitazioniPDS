package esercizio5;

import java.util.Scanner;

/**
 * String ASCII comparison. Return the greater
 * @author zingaretti mattia 
 */
public class Main {

	public static void main(String[] args) {
		//Getting data
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a string: ");
		String s1 = sc.nextLine();
		System.out.print("Type a string: ");
		String s2 = sc.nextLine();
		sc.close();
		
		System.out.println(asciiComparison(s1, s2));
		
	}

	private static String asciiComparison(String s1, String s2) {
		String iterator = s1;
		int c1 = 0; //char counter for string s1
		int c2 = 0; //char counter for string s2
		int j = 0;
		while(j <2 ) {//Giusto perche sono un tipo elegante...
			for(int i = 0; i < iterator.length(); i++) {
				c2 += iterator.charAt(i);
			}
			iterator = s2;
			if (j < 1) {
				c1 = c2;
				c2 = 0;
			}
			j++;
		}
		if (c1>c2) {
			return s1;
		}else {
			return s2;
		}
	}

}
