package esercizio1;

public class Quadrato extends Rettangolo{
	private double l;
	
	public Quadrato(String description, double l) {
		super(description, l, l);
	}
	@Override
	public String toString() {
		return "Figure "+this.description+"\n Area: "+this.area()+"\n Perimetro : "+ this.perimetro();
	}
	
	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

}
