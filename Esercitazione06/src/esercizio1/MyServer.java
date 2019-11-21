package esercizio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable{
	private int port;
	private String ip;
	private ServerSocket sock;//Per le richieste
	
	@Override
	public void run() {
		try {
			this.sock = new ServerSocket(this.port);
			Socket client = null;
			synchronized (this) {//fa in modo che un solo processo per volta entri ad eseguire questa istruzione.
				client = this.sock.accept();//Socket nel server
			}
			if(client != null) {
				new MyClient(client,"SUCCESS").run();//Comunico al client che sono in ascolto
				System.out.print("Server in ascolto sulla porta"+ client.getLocalPort());
			}
			
		} catch (IOException e) {
			System.out.print("Errore in creazione serverSocket");
			e.printStackTrace();
		}
				
		
				
	}
	
}

