package esercizio1.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Model {
	private HashMap<Integer, Panel> grid;
	
	public Model() {
		grid = new HashMap<Integer, Panel>();
	}
	
	public void addPanel(Panel p){
		grid.put(p.getIndex(), p);
	}
	public Panel getPanel(int i) {
		return grid.get(i);
	}
	
	public HashMap<Integer, Panel> getGrid() {
		return grid;
	}
}
