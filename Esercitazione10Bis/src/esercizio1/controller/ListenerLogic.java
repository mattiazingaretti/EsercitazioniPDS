package esercizio1.controller;

import java.awt.event.*;

import esercizio1.model.Process;
import esercizio1.view.GUI;

public class ListenerLogic implements ActionListener {
	private GUI gui;
	private String cmd;
	private Controller c;
	

	public ListenerLogic(GUI g) {
		gui = g;
		c = new Controller(g, g.getModel());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cmd = e.getActionCommand();
		if(!cmd.equals("clear")) {
			Process p = new Process(cmd,c);
			Thread t = new Thread(p);
			t.start();
		}
		gui.updateUI(cmd);
		
	}

}
