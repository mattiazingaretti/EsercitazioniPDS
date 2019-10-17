package esercizio1;

public class FigureException extends Exception {
	public FigureException() {
		
	}
	
	public FigureException(String m) {
		System.out.println(m);
		this.printStackTrace();
	}
}
