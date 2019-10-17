package esercizio1;

public class Triangolo extends Figure{
	private String description;
	private double l1;
	private double l2;
	private double l3;
	
	//Constructor
	public Triangolo( String description, double l1, double l2 , double l3 ){
		super();
		this.setL1(l1);
		this.setL2(l2);
		this.setL3(l3);
		this.setDescription(description);
	}
	@Override
	public String toString() {
		return "Figure "+this.description+"\n Area: "+this.area()+"\n Perimetro : "+ this.perimetro();
	}
	
	//Erone formula
	@Override
	public double area() {
		return Math.sqrt((this.perimetro()/2)*(this.perimetro()/2 - this.l1)*(this.perimetro()/2 - this.l2)*(this.perimetro()/2 - this.l3));
	}

	@Override
	public double perimetro() {
		return this.l1+this.l2+this.l3;
	}
	
	//Getters and setters
	public double getL2() {
		return l2;
	}

	public void setL2(double l2) {
		this.l2 = l2;
	}

	public double getL1() {
		return l1;
	}

	public void setL1(double l1) {
		this.l1 = l1;
	}

	public double getL3() {
		return l3;
	}

	public void setL3(double l3) {
		this.l3 = l3;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
