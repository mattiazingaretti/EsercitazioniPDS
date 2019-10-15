package esercizio2;

import javax.swing.JOptionPane;

public class Client {
	
	/**
	 *Stampa a video una stringa formattata. 
	 * @param args
	 */
	public static void main(String[] args) {
		JOptionPane jp = new JOptionPane();
		String s = jp.showInputDialog("Inserire stringa.");
		
		jp.showMessageDialog(null, esercizio1.StringUtility.formatta(s));
		
	}

}
