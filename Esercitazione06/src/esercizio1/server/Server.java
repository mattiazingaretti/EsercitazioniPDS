package esercizio1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;



public class Server {

	private static final String CONNECT_CMD = "connect";
	public static final int PORT = 9999;// TODO insert it in a config file.
	private static Logger log;
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static Scanner input;
	private static PrintWriter out;

	private Server() {
	}

	public static void main(String[] args) {
		// Initialize logger and a file handler
		log = Logger.getLogger("logger");
		assignFileHandler(log);

		initServer();

		listen();

		connect();

		generateBinaryData();

		closeComunication();

	}

	private static void closeComunication() {
		try {
			socket.close();
			log.info("Done. Comunication completed");
		} catch (IOException e) {
			log.throwing("Server", "socket.close()", new Throwable("Failed to close socket"));
			e.printStackTrace();
		}
	}


	private static void generateBinaryData() {
		// Generate binary data

		try {
			out = new PrintWriter(socket.getOutputStream());
			String newCmd = "";
			while (input.hasNextLine()) {
				newCmd = input.nextLine();
				// Handle stop signal
				if (newCmd.equals("stop")) {
					break;
				}
			}

			String sent = "";
			int iterations = (int) Math.abs(Math.random() * 20 + 1);// Should be at least one
			for (int i = 0; i < iterations; i++) {
				int ran = (int) Math.random() * 10;
				if (ran % 2 == 0) {
					out.println("1");
					sent += "1";
					out.flush();
				} else {
					out.println("0");
					sent += "0";
					out.flush();
				}
			}
			log.info("Sent binary data " + sent);
			log.fine("Binary transmission completed succesful");

			sendTerminationCode();

		} catch (IOException e1) {
			e1.printStackTrace();
			log.throwing("Server", "socket.getOutputStream()", new Throwable("Failed to initialize the PrintWriter"));
		}
	}

	private static void sendTerminationCode() {
		// TODO edit the transmission sequence
		out.println("*");
		out.flush();
		out.println("DoneTransmission");
		out.flush();
		out.println("");
		out.flush();
		out.close();
		input.close();
	}

	private static void connect() {
		// Receive connection request
		try {
			input = new Scanner(socket.getInputStream());
			int i = 0;
			String cmd = "";
			while (input.hasNextLine()) {
				cmd = input.nextLine();
				if (cmd.equals(CONNECT_CMD)) {// Necessary use equals and break
					break;
				}
			}
			log.info("Received command : " + cmd);
		} catch (IOException e) {
			log.throwing("Server", "getInputStream()", new Throwable("Error while dealing with InputStream"));
			e.printStackTrace();
		}
	}

	private static void listen() {
		// Listen for command
		try {
			socket = server.accept();
			log.info("Socket connected!");
		} catch (IOException e) {
			log.throwing("Server", "server.accept()", new Throwable("Excpetion in accept method for the server!"));
			e.printStackTrace();
		}
	}

	private static void initServer() {
		// Initialize Server
		try {
			server = new ServerSocket(PORT);
			log.info("Server Initialized Correctly");
		} catch (IOException e) {
			log.throwing("Server", "ServerSocket Constructor", new Throwable("Incorrect initialization of the Server"));
			e.printStackTrace();
		}
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