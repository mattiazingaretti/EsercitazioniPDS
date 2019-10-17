package esercizio1;

public class Rettangolo extends Figure{
	private double l1;
	private double l2;
	protected String description;

	public Rettangolo(String description, double l1, double l2){
		super();
		this.setDescription(description);
		this.setL1(l1);
		this.setL2(l2);
	}
	
	@Override
	public String toString() {
		return "Figure "+this.description+"\n Area: "+this.area()+"\n Perimetro : "+ this.perimetro();
	}
	@Override
	public double area() {
		return this.l1*this.l2;
	}

	@Override
	public double perimetro() {
		return 2*(this.l1+this.l2);
	}

	public double getL1() {
		return l1;
	}
	public void setL1(double l1) {
		this.l1 = l1;
	}
	public double getL2() {
		return l2;
	}
	public void setL2(double l2) {
		this.l2 = l2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
