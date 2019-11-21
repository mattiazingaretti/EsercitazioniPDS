package esercizio1.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import esercizio1.Main;

public class Server {

	private static final int PORT = 9999;//TODO insert it in a config file.
	private static Logger log ;
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static Scanner input; 
	
	private Server() { }
	
	public static void main(String[] args) {
		//Initialize logger and a file handler
		log = Logger.getLogger("logger");
		assignFileHandler(log);
		
		//Initialize Server
		try {
			server = new ServerSocket(PORT);
			log.info("Server Initialized Correctly");
		} catch (IOException e) {
			log.throwing("Server", "ServerSocket Constructor", new Throwable("Incorrect initialization of the Server"));
			e.printStackTrace();
		}
		
		
		//Listen for command
		try {
			socket = server.accept();
			log.info("Socket connected!");
		} catch (IOException e) {
			log.throwing("Server", "server.accept()", new Throwable("Excpetion in accept method for the server!"));
			e.printStackTrace();
		}
		
		//Receive connection request
		try {
			input = new Scanner(socket.getInputStream());
			int i = 0;
			String cmd = "" ;
			while(input.hasNextLine()) {
				cmd = input.nextLine();
				if(cmd.equals("connect")) {//Necessary use equals and break
					break;
				}
			}
			log.info("Received command : "+cmd);
		} catch (IOException e) {
			log.throwing("Server", "getInputStream()", new Throwable("Error while dealing with InputStream"));
			e.printStackTrace();
		}
		
		//Generate binary data
		//Handle stop signal
		//Send termination code
		
	}

	private static void assignFileHandler(Logger log) {
		try {
			FileHandler fh = new FileHandler("./ServerLog.log");
			log.addHandler(fh);
			log.config("File Handler configured correctly for the server");
		} catch (SecurityException e1) {
			log.throwing("FileHandler", "Constructor of FileHandler class", new Throwable("Permisssion error on file"));
			e1.printStackTrace();
		} catch (IOException e1) {
			log.throwing("FileHandler", "Constructor of FileHandler class", new Throwable("IOExcpetion on the file"));
			e1.printStackTrace();
		}
	}

}
