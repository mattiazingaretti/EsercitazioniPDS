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
	
	private ConnectProcess connectProcess;
	private Thread connectThread;
	private StartStopProcess io;
	private Thread stopThread;
	private Thread startThread;
	private DisconnectProcess disconnectProcess;
	private Thread disconnectThread;
	
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
		
		disconnectProcess = new DisconnectProcess(connectProcess.getClientSocket(), gui);
		disconnectThread = new Thread(disconnectProcess);
		disconnectThread.start();
	}

	private void stop(String cmd) {
		io.setState(cmd);
	}

	private void start(String cmd){
		
		gui.setCurrentStatus("STARTING");
		Main.mainLog.info(gui.getCurrentStatus());
		
		io = new StartStopProcess(connectProcess.getClientSocket(), cmd, gui);
		startThread = new Thread(io);
		startThread.start();
		gui.setCurrentStatus("STARTED");
		Main.mainLog.info(gui.getCurrentStatus());

		gui.updateUIStatus();
	}

	private void connect(String cmd) {
		this.gui.setCurrentStatus("CONNECTION");
		Main.mainLog.info(this.gui.getCurrentStatus());
		
		this.updateValues();
		this.gui.updateUIStatus();
		
		
		connectProcess = new ConnectProcess(gui);
		connectThread = new Thread(connectProcess);
		
		connectThread.start();
		
	}

}
