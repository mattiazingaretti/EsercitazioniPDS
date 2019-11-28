package esercizio1;

import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class ListenerLogic implements ActionListener{

	private Gui gui;
	private String ip;
	private String porta;
	private String matricola;
	private Thread clientThread;
	private ClientHandler clientProcess;
	private ClientHandler startProcess;
	private Thread startThread;
	
	public ListenerLogic(Gui gui) {
		this.gui = gui;
		updateValues();
	}
	
	private void updateValues() {
		ip = gui.getIpText().getText();
		porta = gui.getPortaText().getText();
		matricola = gui.getMatricolaText().getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "connect":
			connect(cmd);
			break;
		case "disconnect":
			disconnect(cmd);
			break;
		case "stop":
			stop(cmd);
			break;
		case "start":
			start(cmd);
			break;
		}
	}

	private void disconnect(String cmd) {
		
	}

	private void stop(String cmd) {
		JButton disconnect = gui.getDisconnectButton();
		disconnect.setEnabled(true);
		JButton stop = gui.getStopButton();
		stop.setEnabled(false);
		
		ClientHandler stopProcess = new ClientHandler(gui, cmd);
		stopProcess.setClientSocket(startProcess.getClientSocket());
		stopProcess.setOut(startProcess.getOut());
		stopProcess.setInput(startProcess.getInput());
		Thread stopThread = new Thread(stopProcess);
		stopThread.start();
	}

	private void start(String cmd) {
		JButton startBtn = gui.getStartButton();
		startBtn.setEnabled(false);
		JButton stop = gui.getStopButton();
		stop.setEnabled(true);
		JButton disconnect = gui.getDisconnectButton();
		disconnect.setEnabled(false);
		
		startProcess = new ClientHandler(gui, cmd);
		startProcess.setClientSocket(this.clientProcess.getClientSocket());
		startThread = new Thread(startProcess);
		startThread.start();
	}

	private void connect(String cmd) {
		this.updateValues();
		
		JButton connect = this.gui.getConnectButton();
		connect.setEnabled(false);
		JButton disconnect = gui.getDisconnectButton();
		disconnect.setEnabled(true);
		JButton stop = this.gui.getStopButton();
		stop.setEnabled(false);
		
		this.gui.setCurrentStatus("CONNECTION");
		Main.mainLog.info(this.gui.getCurrentStatus());
		
		clientProcess = new ClientHandler(gui, cmd);
		clientThread = new Thread(clientProcess);
		clientThread.start();
		
	}

}
