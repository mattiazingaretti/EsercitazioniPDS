package esercizio1;

public class Triangolo extends Figure{
	private double l1;
	private double l2;
	private double l3;
	private double altezza;
	
	//Constructor
	public Triangolo() throws FigureException {
		super();
	}
	
	public Triangolo(String description, double l1, double l2 , double l3, double altezza ){
		super(description);
		this.setL1(l1);
		this.setL2(l2);
		this.setL3(l3);
		this.setAltezza(altezza);//Suppose related to l1;
	}

	@Override
	public double area() {
		return (this.l1*this.altezza)/2;
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

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

}
