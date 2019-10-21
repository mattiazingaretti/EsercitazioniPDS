package esercizio2;

public class Client {

	public static void main(String[] args) {
		ContoCredito cc = new ContoCredito("so io", "Rossi", 1000, "password");
		ContoDebito cd = new ContoDebito("Marco", "Bianchi", 2000, "password2");
		
		cd.deposito(200);
		cc.deposito(100);
		
		System.out.println(cc.getSaldo()+ ": "+ cd.getSaldo());
		
		for(int i = 0 ; i < 5 ; i++) {
			cd.deposito(200);
			cc.deposito(100);
			System.out.println(cc.getSaldo()+ ": "+ cd.getSaldo());
		}
		
		cd.riconosciInteresse(0.5);
		System.out.println("Post interesse: "+ cd.getSaldo());
	}

}
