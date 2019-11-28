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
	private Socket clientSocket;
	
	public ListenerLogic(Gui gui) {
		this.gui = gui;
		updateValues();
	}
	
	private void updateValues() {
		this.ip = gui.getIpText().getText();
		this.porta = gui.getPortaText().getText();
		this.matricola = gui.getMatricolaText().getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "connect":
			connect();
			break;
		case "disconnect":
			break;
		case "stop":
			break;
		case "start":
			break;
		}
	}

	private void connect() {
		this.updateValues();
		JButton connect = this.gui.getConnectButton();
		connect.setEnabled(false);
		try {
			
			this.clientSocket = new Socket(this.ip, Integer.parseInt(this.porta));
			
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "connesso al server");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
