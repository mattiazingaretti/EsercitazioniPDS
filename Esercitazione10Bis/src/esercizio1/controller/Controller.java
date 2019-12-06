package esercizio1.controller;

import java.awt.Color;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

import esercizio1.Common;
import esercizio1.model.Model;
import esercizio1.model.Panel;
import esercizio1.view.GUI;

public class Controller {
	private Model model;
	private GUI g;
	private Socket s;
	private Scanner input;
	private PrintWriter out;

	public Controller(GUI gui, Model m) {
		this.model = m;
		g = gui;
	}

	public void openSocket(String ip, int port) throws UnknownHostException, IOException {
		this.s = new Socket(ip, port);
	}

	public void startDownload(Socket s) {
		try {
			input = new Scanner(s.getInputStream());
			out = new PrintWriter(s.getOutputStream());
			out.println(Common.DOWNLOAD_CMD);
			out.flush();
			String line = "";
			String[] data = new String[2];
			while (input.hasNextLine()) {
				line = input.nextLine();
				data = line.split(";");
				System.out.println("sono nel while");
				System.out.println(data[0] + " " + data[1]);
				if (data[0].equals("-1") && data[1].equals("-1")) {
					break;
				}
				int i = Integer.parseInt(data[0]);
				Panel p = new Panel(new Color(Integer.parseInt(data[1])), i);
				this.model.addPanel(p);
				g.changeColor(model.getPanel(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopDownload(Socket s) throws IOException {
		out.println(Common.STOP_CMD);
		out.flush();
	}

	public void disconnect(Socket s) throws IOException {
		out.println(Common.DISCONNECT_CMD);
		out.flush();
		out.close();
		input.close();
		out.close();
		s.close();
		
	}

	public Socket getS() {
		return s;
	}

	public Model getModel() {
		return model;
	}

	public GUI getG() {
		return g;
	}

}
