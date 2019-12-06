package esercizio1.model;

import java.awt.*;
import javax.swing.*;

public class Panel {
	private Color color;
	private int index;
	
	public Panel(Color c , int i) {
		color = c;
		index = i;
	}
	
	private synchronized boolean isActive() {
		return this.color != Color.LIGHT_GRAY;
	}

	public int getIndex() {
		return index;
	}
	
	public Color getColor() {
		return color;
	}

}
