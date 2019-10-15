package esercizio1;

import java.util.stream.IntStream;

/**
 * Some useful static method for string objects
 * @author zingaretti mattia
 *
 */
public class StringUtility {
	/**
	 * Return true if one string is inside the other 
	 */
	public static boolean checkString(String s2 ,String s1) {
		return s2.contains(s1) || s1.contains(s2);
	}
	
	public static String formatta(String s) {
		String ris = new String();
		for(int i = 0 ; i< s.length(); i++) {
			Character c = new Character(s.charAt(i));
			if(i%2==0) {
				c = c.toUpperCase(c);
				ris = ris.concat(c.toString());
			}else {
				ris = ris.concat(c.toString());
			}
		}
		return ris;
	}

}
