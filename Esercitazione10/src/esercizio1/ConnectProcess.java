package esercizio1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectProcess implements Runnable{
	private Gui gui;
	private Socket clientSocket;
	
	public ConnectProcess(Gui gui) {
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			setClientSocket(new Socket(gui.getIpText().getText(), Integer.parseInt(gui.getPortaText().getText())));
			this.gui.setCurrentStatus("CONNECTED");
			Main.mainLog.info(gui.getCurrentStatus());
		} catch (NumberFormatException | IOException e) {
			Main.mainLog.info("Danni nel creare la connessione");
			e.printStackTrace();
		}
	}
	

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

}
