package esercizio1;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Model implements Runnable{

	private GUI gui;
	private String cmd;
	
	private Scanner input;
	private int[][] data;
	
	private Socket s; 

	public Model(String cmd,GUI gui) {
		this.gui = gui;
		this.cmd = cmd;
		
	}
	
	@Override
	public void run() {
		if(cmd.equals("connect")) {
			try {
				s = new Socket(gui.getIpText().getText(), Integer.parseInt(gui.getPortText().getText()));
			} catch (NumberFormatException | IOException e) {
				System.out.println("Problem opening socket!");
				e.printStackTrace();
			}
		}
		
		if(cmd.equals("start")) {
			try {
				input = new Scanner(s.getInputStream());
				String line = "";
				String data[]  = new String[2];
				while(input.hasNextLine()) {
					line = input.nextLine();
					data = line.split(";");
					if(!data[0].equals("-1") && !data[1].equals("-1")) {
						gui.setCurrentStatus("done");
						break;
					}
					gui.changeColor(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
				}
				input.close();
			} catch (IOException e) {
				System.out.println("Problem initializing scanner");
				e.printStackTrace();
			}
		}
		
	}

	public String getCmd() {
		return cmd;
	}

	public synchronized void setCmd(String cmd) {
		this.cmd = cmd;
	}

}
