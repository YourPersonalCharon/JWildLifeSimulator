package types;

public class Tile {
	public int predators = 0;
	public int prays = 0;
	public String getTile() {
		return predators + "/" + prays;
	}
}
