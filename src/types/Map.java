package types;

public class Map {
	public int height;
	public int width;
	
	public Animal[][] map;
	
	public Map(int width, int height){
		this.height=height;
		this.height=width;
		map = new Animal[height][width];
	}
}
