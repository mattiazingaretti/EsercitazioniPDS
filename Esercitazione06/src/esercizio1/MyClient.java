package esercizio1;

import java.net.Socket;

public class MyClient implements Runnable{
	private Socket socket;
	private String command;
	private boolean inAscolto;
	
	public MyClient(Socket socket, String command) {
		this.setSocket(socket);
		this.command = command;
		this.inAscolto = false;
	}
	@Override
	public void run() {
		switch (this.command) {
		case "SUCCESS":
			this.inAscolto = true;//Importante l'assenza di break in questo caso...
		case "CONNECT":
			
			break;
		case "STOP":
			break;
		case "DISCONNECT":
			break;
		case "START":
			break;
		}
	}
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public boolean isInAscolto() {
		return inAscolto;
	}
	public void setInAscolto(boolean inAscolto) {
		this.inAscolto = inAscolto;
	}
	
}