package esercizio1;

public class Cerchio extends Ellisse{
	private double r;
	private String description;
	
	
	public Cerchio(String description,double r) {
		super(description, r, r);
		this.setDescription(description);
		this.setR(r);
	}

	@Override
	public double area() {
		return this.r*this.r*Math.PI;
	}

	@Override
	public double perimetro() {
		return 2*Math.PI*this.r;
	}

	@Override
	public String toString() {
		return "Figure "+this.description+"\n Area: "+this.area()+"\n Perimetro : "+ this.perimetro();
	}
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
