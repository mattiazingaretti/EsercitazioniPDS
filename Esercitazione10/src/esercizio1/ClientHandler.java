package esercizio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientHandler implements Runnable {

	private String cmd;
	
	private String ip;
	private int port;
	private String matricola;

	private Socket clientSocket;
	private Gui gui;
	
	private PrintWriter out;
	private Scanner input;
	private String firstLine;
	private String secondLine;
	
	public ClientHandler(Gui gui, String cmd) {
		this.cmd = cmd;
		this.gui = gui;
		this.ip = gui.getIpText().getText();
		this.port = Integer.parseInt(gui.getPortaText().getText());
		this.matricola = gui.getMatricolaText().getText();
	}
	
	@Override
	public void run() {
		switch (this.getCmd()) {
		case "connect":
			connect();
			break;
		case "start":
			start();
			break;
		case "disconnect":
			disconnect();
			break;
		case "stop":
			stop();
		default:
			break;
		}
	}

	private void disconnect() {
		this.gui.setCurrentStatus("DISCONNECTION");
		Main.mainLog.info(this.gui.getCurrentStatus());
		
		
		
		this.gui.setCurrentStatus("DISCONNECTED");
		Main.mainLog.info(gui.getCurrentStatus());
	}

	private void stop() {
		this.gui.setCurrentStatus("STOPPING");
		Main.mainLog.info(gui.getCurrentStatus());
		out.println("stop");
		out.flush();
		String line = "";
		while(input.hasNext()) {
			line = input.next();
			if(line.equals("*")) {
				secondLine += line;
				secondLine += input.next();
				secondLine += "stop";
				break;
			}
		}
		out.close();
		input.close();
		this.gui.setCurrentStatus("STOPPED");
		Main.mainLog.info(gui.getCurrentStatus());
		
	}

	private void start() {
		try {
			out = new PrintWriter(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			input = new Scanner(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		out.println("start");
		out.flush();
		firstLine = "";
		String line = "";
		while(input.hasNextLine()) {
			line = input.nextLine();
			if(line.equals("*")) {
				break;
			}else {
				firstLine += line;
			}	
			
		}
		this.gui.setCurrentStatus("DOWNLOADING");
		Main.mainLog.info(gui.getCurrentStatus());
		
		this.gui.setCurrentStatus("DOWNLOADED");
		Main.mainLog.info(gui.getCurrentStatus());
	}

	private void connect() {
		try {
			this.clientSocket = new Socket(ip, port);
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "connesso al server");
			gui.setCurrentStatus("CONNECTED");
			Main.mainLog.info(gui.getCurrentStatus());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}



}
