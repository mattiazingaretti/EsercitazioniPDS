package esercizio1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.*;

public class Gui {
	private JFrame frame;
	private static String[] status = { "CONNECTION", "CONNECTED", "DOWNLOADING", "DOWNLOADED", "STOPPING", "STOPPED",
			"DISCONNECTION", "DISCONNECTED" };
	private String currentStatus = "INITIALIZED";// Starting value of the GUI
	private JPanel mainPanel;
	private JPanel contentPane;
	private JPanel buttonPanel;

	private JTextField portaText;
	private JTextField matricolaText;
	private JTextField ipText;

	private JButton connectButton;
	private JButton stopButton;
	private JButton disconnectButton;
	private JButton startButton;

	private ListenerLogic listener;

	// Keep constructor clean!
	public Gui() {
		frame = new JFrame();
		contentPane = (JPanel) frame.getContentPane();
		setContentPane();

		mainPanel = new JPanel(new GridLayout(4, 2));
		addToMainPanel();

		buttonPanel = new JPanel();
		addToButtonPanel();

		listener = new ListenerLogic(this);
		setListeners();

		addToContentPane();

		setFrame();
		
		Main.mainLog.info("I'm in this status: "+this.currentStatus);
		
	}

	private void setListeners() {
		connectButton.setActionCommand("connect");
		connectButton.addActionListener(listener);

		disconnectButton.setActionCommand("disconnect");
		disconnectButton.addActionListener(listener);

		startButton.setActionCommand("start");
		startButton.addActionListener(listener);

		stopButton.addActionListener(listener);
		stopButton.setActionCommand("stop");
	}

	private void setFrame() {
		// Setting frame
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}

	private void addToButtonPanel() {
		// Initialize components
		connectButton = new JButton("connect");
		disconnectButton = new JButton("disconnect");
		stopButton = new JButton("stop");
		startButton = new JButton("start");

		// Add components to buttonPanel
		buttonPanel.add(connectButton);
		buttonPanel.add(disconnectButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(startButton);
	}

	private void setContentPane() {
		contentPane.setLayout(new BorderLayout());
	}

	private void addToMainPanel() {
		// Initialize components
		portaText = new JTextField(10);
		matricolaText = new JTextField();// Columns value not necessary with the current layout
		ipText = new JTextField();

		// Add components to mainPanel
		mainPanel.add(new JLabel("Porta"));
		mainPanel.add(new JLabel("Ip Address"));
		mainPanel.add(portaText);
		mainPanel.add(ipText);
		mainPanel.add(new JLabel("Matriola"));
		mainPanel.add(new JLabel(""));
		mainPanel.add(matricolaText);
	}

	private void addToContentPane() {
		// Add panels to the contentPane
		contentPane.add(mainPanel, BorderLayout.NORTH);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}

	// GETTERS AND SETTERS

	public JTextField getPortaText() {
		return portaText;
	}

	public JTextField getMatricolaText() {
		return matricolaText;
	}

	public JTextField getIpText() {
		return ipText;
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public JButton getDisconnectButton() {
		return disconnectButton;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public static String[] getStatus() {
		return status;
	}
	
	//Set currentState only if s matches one of the options in the status Array
	public void setCurrentStatus(String s) {
		for (int i = 0; i < status.length; i++) {
			if(s.equals(status[i])) {
				this.currentStatus = s;
				break;
			}
		}
		
	}
	
	public String getCurrentStatus() {
		return currentStatus;
	}

}
