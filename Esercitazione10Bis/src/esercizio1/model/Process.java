package esercizio1.model;

import java.io.IOException;

import esercizio1.Common;
import esercizio1.controller.Controller;

public class Process implements Runnable {
	private String cmd;
	private Controller c;
	
	public Process(String cmd, Controller c) {
		this.cmd  = cmd;
		this.c = c;
	}
	
	@Override
	public synchronized void run() {
		if(this.cmd.equals(Common.CONNECT_CMD)) {
			try {
				c.openSocket(c.getG().getIpText().getText(), Integer.parseInt(c.getG().getPortText().getText()));
			} catch (NumberFormatException | IOException e) {
				System.out.println("errore aprendo la socket");
				e.printStackTrace();
			}
		}
		if(this.cmd.equals(Common.DOWNLOAD_CMD)) {
			c.startDownload(c.getS());
		}
		if(this.cmd.equals(Common.STOP_CMD)){
			try {
				c.stopDownload(c.getS());
			} catch (IOException e) {
				System.out.println("Errore nello stoppare la socket");
				e.printStackTrace();
			}
		}
		if(this.cmd.equals(Common.DISCONNECT_CMD)){
			try {
				c.disconnect(c.getS());
			} catch (IOException e) {
				System.out.println("Erropre nella disconnessione");
				e.printStackTrace();
			}
		}
	}
	
}
