package esercizio1;
/**
 * Abstract class that represents a figure
 * @author zingaretti mattia
 *
 */
public abstract class Figure {
	private String description;
	
	//Constructors
	public Figure() throws FigureException {
		throw new FigureException("Missing params");	
	}
	public Figure(String s) {
		this.setDescription(s);
	}
	
	//Getter setter
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//Services
	public abstract double area() ;
	public abstract double perimetro();
	
	
	public void toString(Figure f) {
		System.out.print("Figure data: \n" +"Perimetro : "+ f.perimetro()+ "\n Area: "+ f.area());
	}
	
	
	public static double sommaAree(Figure[] f) {
		double sum = 0;
		for (int i = 0; i < f.length; i++) {
			sum += f[i].area();
		}
		return sum;
	}
}
