package esercizio1;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======


public class ListenerLogic {
>>>>>>> 8c2d7e1941eb2fc8a547cf3fa0050b485ca734bc

public class ListenerLogic implements ActionListener{
	private String porta;
	private String matricola;
	private String ip;
	
	
	//Gestisco gli eventi click dei vari pulsanti
	public ListenerLogic(MyFrame frame) {
		this.ip = frame.getTxtIP().getText();
		this.matricola = frame.getTxtMatricola().getText();
		this.porta = frame.getTxtMatricola().getText();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "CONNECT":
			connect();
			break;
		case "STOP":
			break;
		case "DISCONNECT":
			break;
		case "START":
			break;
		}
	}
	private void connect() {
		
	}
	public String getPorta() {
		return porta;
	}
	public String getMatricola() {
		return matricola;
	}
	public String getIp() {
		return ip;
	}
	
}
