package esercizio1;

import java.awt.Color;
import java.awt.event.*;

public class ListenerLogic implements ActionListener {
	private GUI gui;
	private String cmd;
	
	public ListenerLogic(GUI g) {
		gui = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cmd = e.getActionCommand();
		switch (cmd) {
		case "connect":
			connect();
			break;
		case "disconnect":
			disconnect();
			break;
		case "start":
			start();
			break;
		case "stop":
			stop();
			break;
		case "clear":
			break;
		}
	}

	private void stop() {
		gui.updateUI(cmd);
		
	}

	private void start() {
		gui.updateUI(cmd);
	}

	private void disconnect() {
		gui.updateUI(cmd);
	}

	private void connect() {
		gui.updateUI(cmd);
	}

	
}
