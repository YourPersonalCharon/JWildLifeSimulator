package types;

import java.util.List;
import java.util.ArrayList;

public class Tile {
	
	public Point coords;
	
	public List<Predator> predators = new ArrayList<Predator>();
	public List<Pray> prays = new ArrayList<Pray>();
	
	public int getPredatorsNumber() {
		return predators.size();
	}
	public int getPraysNumber() {
		return prays.size();
	}
	
	public String getTile() {
		return getPredatorsNumber() + "/" + getPraysNumber();
	}
	
	public Tile(int x, int y) {
		this.coords = new Point(x,y);
	}
}
