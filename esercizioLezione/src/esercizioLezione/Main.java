package esercizioLezione;

public class Main {

	public static void main(String[] args) {
		MYInstructions m1 = new MYInstructions("0");
		MYInstructions m2 = new MYInstructions("1");
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		
		t1.start();
		t2.start();
	}

}
