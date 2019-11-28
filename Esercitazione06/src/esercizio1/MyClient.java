package esercizio1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient implements Runnable{
	private Socket socket;
	private String command;
	
	
	public MyClient(Socket socket, String command) {
		this.command = command;
		this.socket = socket ;//Can't be null
	}
	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("connect");
			out.flush();
			out.close();
			Scanner sc = new Scanner(socket.getInputStream());
			String line1 ="";
			while(sc.hasNextLine()) {
				line1 += sc.nextLine();
			}
			System.out.println(line1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}