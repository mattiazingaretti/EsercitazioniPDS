package esercizio1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import esercizio1.model.Model;
import esercizio1.model.Panel;


public class GUI {
	private static final int GRID_DIMENSION = 256;

	private JFrame frame;
	private String[] status = {"connect", "disconnect", "downloading","done","initialized"};
	private String currentStatus = "initialized";
	
	private JButton start;
	private JButton stop;
	private JButton connect;
	private JButton disconnect;
	private JButton clear;
	
	private JLabel ipLabel;
	private JLabel portLabel;
	
	private JTextField ipText;
	private JTextField portText;
	
	private JPanel[] jPanels;
	private Model m;
	private JPanel contentPane;
	
	private JPanel top;
	private JPanel middle;
	private JPanel bottom;
	
	public GUI(String title, Model m) {
		//Inizializzo il frame
		frame = new JFrame(title);
		this.m = m;
		
		//Initialization of JPanels
		top = new JPanel();
		middle = new JPanel(new GridLayout(16, 16));
		bottom = new JPanel();
		jPanels = new JPanel[GRID_DIMENSION];
		for (int i = 0; i < jPanels.length; i++) {
			jPanels[i] = new JPanel();
		}
		
		//Get content Pane
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//Set components to add into Jpanels
		ipLabel = new JLabel("Ip address");
		portLabel = new JLabel("Port");
		
		ipText = new JTextField(10);
		portText = new JTextField(10);
		
		start = new JButton("start");
		stop = new JButton("stop");
		disconnect = new JButton("disconect");
		clear = new JButton("clear");
		connect = new JButton("connect");
		
		
		//Init listener
		ListenerLogic listener = new ListenerLogic(this);
		
		setListeners(listener);
		
		fillPanels();
		
		addToContentPane();
		
		setFrame();
		
	}

	private void setListeners(ListenerLogic listener) {
		//Set Listeners
		connect.setActionCommand("connect");
		start.setActionCommand("start");
		disconnect.setActionCommand("disconnect");
		stop.setActionCommand("stop");
		clear.setActionCommand("clear");
		
		connect.addActionListener(listener);
		start.addActionListener(listener);
		stop.addActionListener(listener);
		disconnect.addActionListener(listener);
		clear.addActionListener(listener);
	}
	
	private void setFrame() {
		//Set frame
		frame.setLocationRelativeTo(null);
		this.updateUI(this.getCurrentStatus());
		frame.setVisible(true);
		frame.pack();
	}

	private void addToContentPane() {
		//Adding Panel to contentPane
		contentPane.add(top, BorderLayout.NORTH);
		contentPane.add(middle, BorderLayout.CENTER);
		contentPane.add(bottom, BorderLayout.SOUTH);
	}

	private void fillPanels() {
		//Filling jpanels
		top.add(start);
		top.add(ipLabel);
		top.add(ipText);
		top.add(portLabel);
		top.add(portText);
		top.add(stop);
		
		//Filling grids
		for (int i = 0; i < jPanels.length; i++) {
			middle.add(jPanels[i]);
		}
		
		bottom.add(connect);
		bottom.add(disconnect);
		bottom.add(clear);
	}
	
	public void updateUI(String cmd) {
		switch (cmd) {
		case "initialized":
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			start.setEnabled(false);
			stop.setEnabled(false);
			disconnect.setEnabled(false);
			clear.setEnabled(false);
			break;
		case "connect":
			connect.setEnabled(false);
			frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
			start.setEnabled(true);
			disconnect.setEnabled(true);
			clear.setEnabled(true);
			this.setCurrentStatus("connect");
			break;
		case "disconnect":
			disconnect.setEnabled(false);
			start.setEnabled(false);
			connect.setEnabled(true);
			clear.setEnabled(false);
			this.setCurrentStatus("disconnect");
			break;
		case "start":
			start.setEnabled(false);
			connect.setEnabled(false);
			stop.setEnabled(true);
			clear.setEnabled(false);
			disconnect.setEnabled(false);
			this.setCurrentStatus("downloading");
			break;
		case "stop":
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			disconnect.setEnabled(true);
			stop.setEnabled(false);
			this.setCurrentStatus("done");
			clear.setEnabled(true);
			start.setEnabled(false);
			break;
		case "clear":
			for (int i = 0; i < jPanels.length; i++) {
				jPanels[i].setBackground(Color.LIGHT_GRAY);
			}
			break;
		}
	}

	public void changeColor(Panel p) {
		jPanels[p.getIndex()].setBackground(p.getColor());
	}
	
	
	public void setCurrentStatus(String string) {
		for (int i = 0; i < status.length; i++) {
			if(status[i].equals(string)) {
				this.currentStatus = string;
				break;
			}
		}
	}

	public static int getGridDimension() {
		return GRID_DIMENSION;
	}

	public JFrame getFrame() {
		return frame;
	}

	public String[] getStatus() {
		return status;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public JButton getStart() {
		return start;
	}

	public JButton getStop() {
		return stop;
	}

	public JButton getConnect() {
		return connect;
	}

	public JButton getDisconnect() {
		return disconnect;
	}

	public JButton getClear() {
		return clear;
	}
	
	public JTextField getIpText() {
		return ipText;
	}

	public JTextField getPortText() {
		return portText;
	}

	public JPanel getTop() {
		return top;
	}

	public JPanel getMiddle() {
		return middle;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public Model getModel() {
		return this.m;
	}

	
}
