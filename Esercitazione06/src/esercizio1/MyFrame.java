package esercizio1;

import java.awt.*;
import javax.swing.*;


public class MyFrame extends JFrame{
	//Components needed in this frame
	//Buttons
	private JButton connect = new JButton("Connect");
	private JButton disconnect = new JButton("Disconnect");
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");
	
	//Label
	private JLabel matricola = new JLabel("Matricola");
	private JLabel ip = new JLabel("IP Address");
	private JLabel porta = new JLabel("Porta");

	//TextFields
	private JTextField txtMatricola = new JTextField();
	private JTextField txtIP = new JTextField();
	private JTextField txtPorta = new JTextField();
	
	//Panel container
	private FlowLayout flow = new FlowLayout();
	private GridLayout gridLeft = new GridLayout(4, 1);
	private GridLayout gridRight = gridLeft;
	private JPanel topPanelLeft = new JPanel(gridLeft);
	private JPanel topPanelRight = new JPanel(gridRight);
	private JPanel bottomPanel = new JPanel(flow);

	public MyFrame(String s) {
		super(s);
		
		//Getting context pane
		Container contentPane = this.getContentPane(); 
		contentPane.setLayout(new BorderLayout());
		
		
		topPanelLeft.add(matricola);
		txtMatricola.setSize(300, 15);
		topPanelLeft.add(txtMatricola);
		topPanelLeft.add(ip);
		txtIP.setSize(300, 15);
		topPanelLeft.add(txtIP);
		
		
		topPanelRight.add(porta);
		topPanelRight.add(txtPorta);
		
		
		bottomPanel.add(connect);
		bottomPanel.add(disconnect);
		bottomPanel.add(start);
		bottomPanel.add(stop);
		bottomPanel.setSize(100,150);
		
		contentPane.add(topPanelLeft, BorderLayout.BEFORE_LINE_BEGINS);
		contentPane.add(topPanelRight,BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
