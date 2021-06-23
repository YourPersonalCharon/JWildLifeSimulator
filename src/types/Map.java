package types;


import program.C;

public class Map {
	public int height;
	public int width;
	
	public Tile[][] map;
	
	public String getTile(int x, int y) {
		return map[y][x].getTile();
	}
	
	
	public Map(int width, int height){
		this.height=height;
		this.width=width;
		map = new Tile[height][width];
	}


	public void clear() {
		for(int x = 0; x < C.WIDTH; x++) {
			for(int y = 0; y < C.HEIGHT; y++) {
				map[y][x] = new Tile();
			}
		}
	}
	
	public void draw(Population animals) {
		
		this.clear();
		
		for(Predator predator : animals.predators) {
			map[predator.position.y][predator.position.x].predators++;
		}
		for(Pray pray : animals.prays) {
			map[pray.position.y][pray.position.x].prays++;
		}
	}
}
