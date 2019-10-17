package esercizio1;

public class Ellisse extends Figure {

	private String description;
	private double a; //Semiasse maggiore 
	private double b;//semiasse minore
	
	public Ellisse(String description, double a, double b) {
		super();
		this.description = description;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double area() {
		return Math.PI*a*b;
	}

	@Override
	public double perimetro() {
		return 4*a;
	}

	@Override
	public String toString() {
		return "Figure "+this.description+"\n Area: "+this.area()+"\n Perimetro : "+ this.perimetro();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

}
