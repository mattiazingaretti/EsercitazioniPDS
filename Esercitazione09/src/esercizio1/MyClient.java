package esercizio1;

import java.io.IOException;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("", 80);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ip = "192.168.50.82";
		int port = 9999;
	}

}
