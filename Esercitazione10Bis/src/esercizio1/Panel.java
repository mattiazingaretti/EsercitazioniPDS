package esercizio1;

import java.awt.*;
import javax.swing.*;

public class Panel {
	private Color color;
	private int index;
	private JPanel panel;
	
	public Panel(JPanel p,Color c , int i) {
		color = c;
		index = i;
		panel = p;
	}
	
	private synchronized boolean isActive() {
		return this.color != Color.LIGHT_GRAY;
	}

	public JPanel getPanel() {
		return panel;
	}
}
