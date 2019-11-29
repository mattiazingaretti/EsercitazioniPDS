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
	public synchronized void run() {
		switch (this.getCmd()) {
		case "connect":
			connect();
			break;
		case "start":
			start(this.getCmd());
			break;
		case "disconnect":
			disconnect();
			break;
		case "stop":
			start(this.getCmd());
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

	

	private synchronized void start(String cmd) {
		try {
			out = new PrintWriter(clientSocket.getOutputStream());
			input = new Scanner(clientSocket.getInputStream(), "UTF-8");

			out.println(cmd);
			out.flush();
			firstLine = "";
			secondLine = "";
			String line = "";
			while (input.hasNextLine()) {
				line = input.nextLine();
				System.out.println(line);
				if (line.length() > 1) {
					secondLine += "*";
					secondLine += line;
					secondLine += "stop";
					break;
				} else {
					firstLine += line;
				}
			}
			input.close();
			out.close();
			this.gui.setCurrentStatus("DOWNLOADING");
			Main.mainLog.info(gui.getCurrentStatus());

			this.gui.setCurrentStatus("DOWNLOADED");
			Main.mainLog.info(gui.getCurrentStatus());
			System.out.println(firstLine);
			System.out.println(secondLine);

		} catch (IOException e) {
			e.printStackTrace();
		}
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
