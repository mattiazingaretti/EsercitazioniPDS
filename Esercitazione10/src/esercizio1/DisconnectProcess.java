package esercizio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DisconnectProcess implements Runnable{
	
	private Scanner input;
	private PrintWriter out;
	
	private Socket clientSocket;
	
	private Gui gui;
	
	
	public DisconnectProcess(Socket socket, Gui gui) {
		this.clientSocket = socket;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			out = new PrintWriter(clientSocket.getOutputStream());
			input = new Scanner(clientSocket.getInputStream());
			gui.setCurrentStatus("DISCONNECTION");
			Main.mainLog.info(gui.getCurrentStatus());
			out.println("disconnect");
			out.flush();
			out.close();
			input.close();
			clientSocket.close();
			gui.setCurrentStatus("DISCONNECTED");
			gui.updateUIStatus();
			Main.mainLog.info(gui.getCurrentStatus());
			
		} catch (IOException e) {
			Main.mainLog.info("Danni nell'inizializzare printWriter");
			e.printStackTrace();
		}
		
	}

}
