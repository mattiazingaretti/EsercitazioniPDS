package esercizio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StartStopProcess implements Runnable {
	
	private Gui gui;
	
	private String state;
	private Socket clientSocket;

	private Scanner input;
	private PrintWriter out;
	private String data;

	public StartStopProcess(Socket socket, String cmd ,Gui gui) {
		this.gui = gui;
		this.clientSocket = socket;
		this.state = cmd;
		this.data = new String();
		try {
			input = new Scanner(clientSocket.getInputStream());
			out = new PrintWriter(clientSocket.getOutputStream());
		} catch (IOException e) {
			Main.mainLog.info("Danni nel creare Scanner o printWriter");
			e.printStackTrace();
		}

	}

	@Override
	public synchronized void run() {
			out.println("start");
			out.flush();
			String line = new String();
			while (input.hasNextLine()) {
				line = input.nextLine();
				if(!line.equals(null)) {
					data += line;
				}
				if (this.state.equals("stop")) {
					gui.setCurrentStatus("STOPPING");
					Main.mainLog.info(gui.getCurrentStatus());
					out.println("stop");
					out.flush();
					for (int i = 0; i < 3; i++) {
						data += input.nextLine();
					}
					Utils.generateFile(data, gui.getMatricolaText().getText()+Utils.FILE_EXTENSION);
					gui.setCurrentStatus("STOPPED");
					gui.updateUIStatus();
					Main.mainLog.info(gui.getCurrentStatus());
					Main.mainLog.info(data);
					break;
				}
			}
			try {
				Thread.currentThread().sleep(10);
			} catch (Exception e) {
				Main.mainLog.info("Danni nel mettere a dorire il thread");
			}
			
	}

	public synchronized String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
