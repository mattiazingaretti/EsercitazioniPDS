package esercizio1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class Gui extends JFrame{
	private JPanel mainPanel;
	private JPanel contentPane ;
	private JPanel buttonPanel;
	
	private BorderLayout border;
	
	private JTextField portaText;
	private JTextField matricolaText;
	private JTextField ipText;
	
	private JButton connectButton;
	private JButton stopButton;
	private JButton disconnectButton;
	private JButton startButton;

	
	public Gui() {
		super();
		
		contentPane = (JPanel) this.getContentPane();
		
		mainPanel = new JPanel(new GridLayout(4, 2));
		mainPanel.add(new JLabel("Porta"));
		mainPanel.add(new JLabel("Matricola"));
		
		portaText = new JTextField(10);
		mainPanel.add(portaText);
		
		matricolaText = new JTextField(10);
		mainPanel.add(matricolaText);
		
		mainPanel.add(new JLabel("Ip address"));
		mainPanel.add(new JLabel(""));
		ipText = new JTextField(10);
		mainPanel.add(ipText);
		
		buttonPanel = new JPanel();
		
		ListenerLogic listener = new ListenerLogic(this);
		
		connectButton = new JButton("connect");
		disconnectButton = new JButton("disconnect");
		startButton = new JButton("start");
		stopButton = new JButton("stop");
		
		connectButton.setActionCommand("connect");
		connectButton.addActionListener(listener);
		disconnectButton.setActionCommand("disconnect");
		disconnectButton.addActionListener(listener);
		startButton.setActionCommand("start");
		startButton.addActionListener(listener);
		stopButton.setActionCommand("stop");
		stopButton.addActionListener(listener);
		
		buttonPanel.add(connectButton);
		buttonPanel.add(disconnectButton);
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mainPanel, BorderLayout.NORTH);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}


	public JPanel getButtonPanel() {
		return buttonPanel;
	}


	public BorderLayout getBorder() {
		return border;
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

	
	public JTextField getPortaText() {
		return portaText;
	}

	public JTextField getMatricolaText() {
		return matricolaText;
	}

	public JTextField getIpText() {
		return ipText;
	}
}
