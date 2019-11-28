package esercizio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;


public class ListenerLogic implements ActionListener{
	private static final String CLIENT_IP = "127.0.0.1";
	private String porta;
	private String matricola;
	private String ip;
	private Socket clientSocket;
	private MyFrame UIFrame;
	
	//Gestisco gli eventi click dei vari pulsanti
	public ListenerLogic(MyFrame frame) {
		this.ip = frame.getTxtIP().getText();
		this.matricola = frame.getTxtMatricola().getText();
		this.porta = frame.getTxtMatricola().getText();
		this.UIFrame = frame;
		
		//Initialize the socket for connection
		try {
			this.clientSocket = new Socket(CLIENT_IP, esercizio1.server.Server.PORT);
			//TODO Implements a logger...
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "CONNECT":
			connect(e);
			break;
		case "STOP":
			break;
		case "DISCONNECT":
			break;
		case "START":
			break;
		}
	}
	private void connect(ActionEvent e) {
		//Enables the other buttons
		JButton disconnect = this.UIFrame.getDisconnect();
		JButton start = this.UIFrame.getStart();
		disconnect.setEnabled(true);
		start.setEnabled(true);
		
		//Create a thread that connects to the server
		MyClient connectionProcess = new MyClient(this.clientSocket, "connect");
		Thread t1 = new Thread(connectionProcess);
		t1.start();
		
		//Disable connect button until connection established
		JButton connect = (JButton) e.getSource();
		while(t1.isAlive()) {
			connect.setEnabled(false);
		}
		
	}
	
	public String getPorta() {
		return porta;
	}
	public String getMatricola() {
		return matricola;
	}
	public String getIp() {
		return ip;
	}
	
}
