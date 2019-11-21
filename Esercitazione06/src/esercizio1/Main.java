package esercizio1;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		//MyFrame frame = new MyFrame("");
		//Connetto al server
		Socket socket;
		try {
			socket = new Socket("192.168.50.82", 9999);
			System.out.println("conneso");
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("start");//Sempre con \n
			out.flush();
			System.out.println("ho mandato start");
			Scanner sc = new Scanner(socket.getInputStream());
			String line = "";
			int i = 0;
			while(i< 30 ) {
				line += sc.nextLine();
				System.out.println(line);
				i++;
			}
			
			out.println("stop");//Sempre con \n
			out.flush();
			System.out.println("Scritto stop su server");
			
			String newLine = "";
			while(true) {
				newLine += sc.nextLine();
				if(newLine.contains("stop")) {
					break;
				}
			}
			System.out.println(newLine);
			System.out.println(newLine.split("\\*")[1]);
			out.close();
			sc.close();
			socket.close();
		} catch (IOException e) {
			System.out.print("Failed to connect server");
			e.printStackTrace();
		}
	}
	
}
