package esercizio1;

public class Client {

	public static void main(String[] args) {
		Cerchio c = new Cerchio("Cerchio", 5);
		Ellisse e = new Ellisse("Ellisse" , 4,5);
		Triangolo t = new Triangolo("Triangolo" ,3 ,4,3);
		Quadrato q = new Quadrato("Quadrato",4);
		Rettangolo ret = new Rettangolo("Rettangolo", 5, 4);
		
		Figure[] f = {c, e , t, q, ret};
		for(int i = 0 ; i < f.length; i++) {
			System.out.println(f[i].toString());
		}
		System.out.println(Figure.sommaAree(f));
	}
}
